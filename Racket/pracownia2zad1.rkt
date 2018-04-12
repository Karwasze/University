#lang racket

(define (frac n d x)
  
  (define (dist x y)
    (abs (- x y)))

  (define (good-enough? x)
    (< (dist (test x) (test (+ x 1))) 0.0001))

  (define (an x)
    (cond
      [(= x -1) 1]
      [(= x 0) 0]
      [else (+ (* (d x) (an (- x 1))) (* (n x) (an (- x 2))))]))

  (define (bn x)
    (cond
      [(= x -1) 0]
      [(= x 0) 1]
      [else (+ (* (d x) (bn (- x 1))) (* (n x) (bn (- x 2))))]))

  (define (test x)
    (/ (an x) (bn x)))

  (if (good-enough? x)
    (test x)
    (frac n d (+ x 1))))

(define (pi)
  (+ 3 (frac (lambda (x) (* (+ (* 2.0 (- x 1.0)) 1.0) (+ (* 2.0 (- x 1.0)) 1.0))) (lambda (x) 6.0) 1)))

(define (arctan x)
  (frac (lambda (i) (if (= i 1) x (* (* (- i 1) x) (* (- i 1) x)))) (lambda (i) (- (* 2.0 i) 1)) 1))

(println "1/fi")
(frac (lambda (x) 1.0) (lambda (x) 1.0) 1)

(println "pi")
(pi)

(println "arctan(1)")
(arctan 1)

(println "arctan(-1)")
(arctan -1)

(println "arctan(0)")
(arctan 0)

(println "arctan(3)")
(arctan 3)

(println "arctan(-3)")
(arctan -3)

(println "arctan(2.14)")
(arctan 2.14)

(println "arctan(pi)")
(arctan (pi))



