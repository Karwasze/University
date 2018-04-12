#lang racket
(require rackunit)

(define (const? t)
  (number? t))

(define (binop? t)
  (and (list? t)
       (= (length t) 3)
       (member (car t) '(+ - * /))))

(define (binop-op e)
  (car e))

(define (binop-left e)
  (cadr e))

(define (binop-right e)
  (caddr e))

(define (binop-cons op l r)
  (list op l r))

(define (op->proc op)
  (cond [(eq? op '+) +]
        [(eq? op '*) *]
        [(eq? op '-) -]
        [(eq? op '/) /]))

(define (let-def? t)
  (and (list? t)
       (= (length t) 2)
       (symbol? (car t))))

(define (let-def-var e)
  (car e))

(define (let-def-expr e)
  (cadr e))

(define (let-def-cons x e)
  (list x e))

(define (let? t)
  (and (list? t)
       (= (length t) 3)
       (eq? (car t) 'let)
       (let-def? (cadr t))))

(define (let-def e)
  (cadr e))

(define (let-expr e)
  (caddr e))

(define (let-cons def e)
  (list 'let def e))

(define (var? t)
  (symbol? t))

(define (var-var e)
  e)

(define (var-cons x)
  x)

(define (hole? t)
  (eq? t 'hole))

(define (arith/let/holes? t)
  (or (hole? t)
      (const? t)
      (and (binop? t)
           (arith/let/holes? (binop-left  t))
           (arith/let/holes? (binop-right t)))
      (and (let? t)
           (arith/let/holes? (let-expr t))
           (arith/let/holes? (let-def-expr (let-def t))))
      (var? t)))

(define (num-of-holes t)
  (cond [(hole? t) 1]
        [(const? t) 0]
        [(binop? t)
         (+ (num-of-holes (binop-left  t))
            (num-of-holes (binop-right t)))]
        [(let? t)
         (+ (num-of-holes (let-expr t))
            (num-of-holes (let-def-expr (let-def t))))]
        [(var? t) 0]))

(define (arith/let/hole-expr? t)
  (and (arith/let/holes? t)
       (= (num-of-holes t) 1)))

(define empty-env
  null)

(define (add-to-env x v env)
  (cons (list x v) env))

(define (hole-context-env e env)
  (cond
    [(hole? e) env]
    [(binop? e) (cond
                  [(= (num-of-holes(binop-left e)) 1) (hole-context-env (binop-left e) env)]
                  [(= (num-of-holes(binop-right e)) 1) (hole-context-env (binop-right e) env)])]
    [(and (let? e) (hole? (let-def-expr (let-def e)))) '()]
    [(and
      (let? e)
      (not (hole? (let-def-expr (let-def e))))
     (add-to-env (let-def-var (let-def e)) (hole-context (let-expr e)) env))]
    ))
    

(define (hole-context e)
  (remove-duplicates (flatten (hole-context-env e empty-env))))
  

(define (test)
  (begin
    (println (equal? (sort (hole-context '(+ (let (x 5) 5) (let(y 6) hole))) symbol<?) '(y)))
    (println (equal? (sort (hole-context '(+ (let (x 5) (+ (let (y 7) hole) 8)) 5)) symbol<?) '(x y)))
    (println (equal? (sort (hole-context '(+ (+ (let (x 4) hole) 7) (let (y 5) 7))) symbol<?) '(x)))
    (println (equal? (sort (hole-context '(+ (+ (let (y 7) 9) (let (z 10) hole)) (let (x 5) 7))) symbol<?) '(z)))
    (println (equal? (sort (hole-context '(+ (+ (let (x 4) 6) 5) (let (y 7) hole))) symbol<?) '(y)))
    (println (equal? (sort (hole-context '(+ (+ (let (x 5) 5) 5) hole)) symbol<?) '()))
    (println (equal? (sort (hole-context '(let (x 9) (let (y 9) (let (z 10) (let (a 11) (let (b 12) hole)))))) symbol<?) '(a b x y z))))
  )

(test)