#lang racket

;; expressions

(define (const? t)
  (number? t))

(define (op? t)
  (and (list? t)
       (member (car t) '(+ - * /))))

(define (op-op e)
  (car e))

(define (op-args e)
  (cdr e))

(define (op-cons op args)
  (cons op args))

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

(define (arith/let-expr? t)
  (or (const? t)
      (and (op? t)
           (andmap arith/let-expr? (op-args t)))
      (and (let? t)
           (arith/let-expr? (let-expr t))
           (arith/let-expr? (let-def-expr (let-def t))))
      (var? t)))

;; let-lifted expressions

(define (arith-expr? t)
  (or (const? t)
      (and (op? t)
           (andmap arith-expr? (op-args t)))
      (var? t)))

(define (let-lifted-expr? t)
  (or (and (let? t)
           (let-lifted-expr? (let-expr t))
           (arith-expr? (let-def-expr (let-def t))))
      (arith-expr? t)))

;; generating a symbol using a counter

(define (number->symbol i)
  (string->symbol (string-append "x" (number->string i))))

;; environments (could be useful for something)

(define empty-env
  null)

(define (add-to-env x v env)
  (cons (cons x v) env))

(define (find-in-env x env)
  (cond [(null? env) (error "undefined variable" x)]
        [(eq? x (caar env)) (cdar env)] 
        [else (find-in-env x (cdr env))]))

;; the let-lift procedure

(define (lift-env e)
  (define (result env exp)
    (cond
      [(null? env) exp]
      [(result (cdr env) (let-cons (let-def-cons (car(car env)) (cdr(car env))) exp))]))
  (result (first (let-lift-env e empty-env 0)) (second (let-lift-env e empty-env 0))))


(define (let-lift-env e env counter)
  (cond
    [(const? e) (list null e counter)]
    [(op? e) (let ([x (let-lift-env (car (op-args e)) env counter)])
               (let ([y (let-lift-env (car (cdr (op-args e))) env (third x))])
               (list
                (append
                 (car y)
                 (car x))
               (list (car e) (second x) (second y))
                (third y))))]
             
    
    [(let? e) (let ([x (let-lift-env (second (let-def e)) env counter)])
                 (let ([y (let-lift-env (let-expr e) (add-to-env (car (let-def e)) (number->symbol (third x)) env) (+ (third x) 1))])
                   (list (add-to-env (number->symbol (third x)) (second x) (append (first x) (first y))) (second y) (third y))))]
                   
    [(var? e) (list null (find-in-env e env) counter)]))

(lift-env '(+ 10 (* ( let ( x 7) (+ x 2) ) 2) ))
(lift-env '( let ( x (- 2 ( let ( z 3) z ) ) ) (+ x 2) ))
(lift-env '(let (x (let (z 1) 4)) (let (y 7) 13)))
(lift-env '(let (x 3) x))
(lift-env '(+ ( let ( x 5) x )( let ( x 1) x ) ))
(lift-env '(* (let (x 3) (let (y 4) (* x y))) (+ 2 3)))
(lift-env '(let (y 4) (+ 3 y)))
(lift-env '(+ 2 (let (x (* 2 3)) (+ x 3))))

