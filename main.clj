;;Leonardo Silva de Abreu

(comment "
 1. Na  aula  disponível  em:  https://replit.com/@frankalcantara/ClojureAula2?v=1 foram destacadas diversas funções (expressões), como funções de primeira ordem, disponíveis em Clojure.  Sua  primeira  tarefa  será  descrever  cada  uma  destas  funções  e  apresentar  dois exemplos  de  uso  de  cada  uma  delas.  Lembre-se  os  exemplos  precisam  ser utilizados  de forma que o resutado da função possa ser visto no terminal.")

;;assoc funciona como se fosse um replace que pode ser usado um mapa ou um vetor(não é aplicado a lista)
;;aplicado ao vetor substitui a posição 0 do vetor [1,2,3] pelo inteiro 10
(def vecAssoc (assoc [1 2 3] 0 10))
(println "assoc aplicada a vetor: (assoc [1 2 3] 0 10) = " vecAssoc)

;;aplicado a um maoa retorna um novo mapa substituindo as chaves antigas pelas novas e adicionando novas chaves
(def mapAssoc (assoc {:key1 "old value1" :key2 "value2"}
                     :key1 "value1" :key3 "value3"))
(println "assoc aplicada a mapa: (assoc {:key1 'old value1' :key2 'value2'} :key1 'value1' :key3 'value3')) = "  mapAssoc)

;;dissoc é aplicado a mapas e retorna um novo mapa sem a chave que foi passada como parametro
;; Remove a chave b do mapa {:a 1 :b 2 :c 3}
(def dissocEx1 (dissoc {:a 1 :b 2 :c 3} :b))
(println "dissoc: (dissoc {:a 1 :b 2 :c 3} :b) = " dissocEx1)

;;Neste caso não irá remover nada apenas retornar um novo mapa igual ao original
(def dissocEx2 (dissoc {:a 1 :b 2 :c 3}))
(println "dissoc: (dissoc {:a 1 :b 2 :c 3}) = " dissocEx2)

;;range cria uma lista, é lazy evaluation (range) => (0,1,2,3...n)
;;cria uma sequencia de 5 a 10
(def rangeEx1 (range 5 11))
(println "range de 5 a 10: " rangeEx1)

;;Cira uma sequencia infinita e pega os 5 primeiros elementos(só é possivel por ser lazy evaluation, pois não irá gerar uma lista infinita mas apenas 5 elementos)
(def rangeEx2 (take 5 (range)))
(println "primeiros 5 elementos de uma sequencia de inteiros infinita: " rangeEx2)

;;map retorna uma coleção dada uma fução aplicada a uma coleção de itens original (vetor, lista, etc). è lazy evaluation
;;incrementa todos os elementos da lista em 1
(def mapEx1 (map inc [1,2,3,4]))
(println "(map inc [1,2,3,4]): " mapEx1)

;;retorna uma coleção com apenas os elementos na posição "a"
(def mapEx2 (map :a '({:a 1 :b 0} {:a 2 :b 0} {:a 3 :b 1} {:a 3 :b 0})))
(println "(map :a '({:a 1 :b 0} {:a 2 :b 0} {:a 3 :b 1} {:a 3 :b 0})): " mapEx2)

;;filter dado um predicado e uma coleção, retorna uma sequencia de todos os elementos da coleção que são verdadeiros de acordo com o predicado
;;filtra os numeros pares de 0 a 9
(def filterEx1 (filter even? (range 10)))
(println "(filter even? (range 10)): " filterEx1)

;;é possivel utilizar um set de valores como predicado para o filter, neste caso representa a intersecção dos conjuntos
(def filterEx2 (filter #{0 1 2 3} #{2 3 4 5}))
(println "(filter #{0 1 2 3} #{2 3 4 5}): " filterEx2)

;;into retorna uma coleção contendo todos os itens  das coleções passadas como parametro, também aceita um "predicado"
;;adiciona a sequencia (4,5,6) no vetor [1,2,3]
(def intoEx1 (into [1 2 3] '(4 5 6)))
(println "(into [1 2 3] '(4 5 6)): " intoEx1)

;;usando into para ordenar um mapa (na verdade ele retorna uma mapa ordenado a partir do mapa original fornecido)
(def intoEx2 (into (sorted-map) {:b 2 :c 3 :a 1}))
(println "(into (sorted-map) {:b 2 :c 3 :a 1}): " intoEx2)

;;nth retorna o elemento na posição n, pode ser passado um argumanto not-fount que será o valor retornado se a posição não existir, se o argumento not-found não for passado irá retornar uma exeção IndexOutOfBoundsException
;;retorna 1 que é o elemento na posição 0
(def nthEx1 (nth [1,2,3,4,5] 0))
(println "(nth [1,2,3,4,5] 0): " nthEx1)

;;retorna uma string, pois, não existe a posição nove 
(def nthEx2 (nth [1,2,3,4,5] 9 "posicao 9 nao existe"))
(println "(nth [1,2,3,4,5] 9): " nthEx2)

;;conj recebe uma coleção e retorna uma nova coleção com novos items
;;adiciona 0 elemento quatro ao vetor [1,2,3]
(def conjEx1 (conj [1 2 3] 4))
(println "(conj [1 2 3] 4): " conjEx1)

;;concatena dois mapas
(def conjEx2 (conj {:nome "Leonardo" :sobrenome "Silva"} {:idade 24 :curso "bcc"}))
(println "(conj {:nome 'Leonardo' :sobrenome 'Silva'} {:idade 24 :curso 'bcc'}): " conjEx2)

;;sort recebe uma coleção e retorna um sequencia ordenada
;ordenando um vetor de inteiros
(def sortEx1 (sort [3 1 2 4]))
(println "(sort [3 1 2 4]): " sortEx1)

;;retorna uma sequencia de caracteres ordenados
(def sortEx2 (sort "alfabeto!321"))
(println "(sort 'alfabeto!321'): " sortEx2)

;;partition-by retorna um conjunto particionado de uma coleção dado um predicado. Esta função vai pegando os elementos em que o predicado retorna verdadeiro e colocando em uma sequencia até o predicado ser falso, ai começa novamente a pegar os itens e adicionar em uma sequencia, até o predicado retornar outro valor de novo
;retorna conjuntos de caracteres
(def partitionByEx1 (partition-by char "alfabeto"))
(println "(partition-by char 'alfabeto'): " partitionByEx1)

;;particionando por numeros pares
;; [1 1 1 2 2 3 3]
;; even? 1 = false (1)
;; even? 1 = false (1,1)
;; even? 1 = false (1,1,1)
;; even? 2 = true ((1,1,1), (2))
;; even? 2 = true ((1,1,1), (2,2))
;; even? 3 = false ((1,1,1), (2,2), (3))
;; even? 3 = false ((1,1,1), (2,2), (3,3))
(def partitionByEx2 (partition-by even? [1 1 1 2 2 3 3]))
(println "(partition-by even?  [1 1 1 2 2 3 3]): " partitionByEx2)

;;intersection retorna a interseção das coleções passadas como parametro
(use 'clojure.set)
;;retorna a interseção de #{1 2} #{2 3} que é #{2}
(def intersectionEx1 (intersection #{1 2} #{2 3}))
(println "(intersection #{1 2} #{2 3}): " intersectionEx1)

;;ira retornar um conjunto vazio
(def intersectionEx2 (intersection #{"1" "3" "5"} ["1" "3" "5" "7"]))
(println "(intersection #{'1' '3' '5'} ['1' '3' '5' '7']): " intersectionEx2)

;;difference retorna uma coleção que é a primeira coleção sem os elementos das coleções restantes
(def differenceEx1 (difference #{1 2} #{2 3}))
(println "(difference #{1 2} #{2 3}): " differenceEx1)

(def differenceEx2 (difference #{1 2 5} #{1} #{1 4} #{3}))
(println "(difference #{1 2 3} #{1} #{1 4} #{3}): " differenceEx2)


(comment "
 2. Utilizando a linguagem Clojure, crie uma função chamada ehPrimo que receba um inteiro e devolva True caso este inteiro seja verdadeiro e False caso contrário.  ")
(defn divisorDe [x y]
  (= 0 (mod x y)))

(defn ehPrimo [x]
  (= (filter #(divisorDe x %) (range 2 x)) []))

(comment "
 3. Utilizando  a  linguagem  Clojure,  crie  uma  função  chamada fatoresPrimos  que  receba  um inteiro e devolva uma lista dos seus fatores primos. Decomposição em fatores primos é uma tarefa fundamental da aritmética. ")
(defn menorFatorPrimo
  [x]
  (loop [i 2]
    (cond
      (and (ehPrimo i)
           (zero? (mod x i))) i
      :else (recur (inc i)))))

(defn fatoresPrimos [x]
  (if (= 1 (/ x (menorFatorPrimo x))) (list (menorFatorPrimo x))
      (concat (list (menorFatorPrimo x)) (fatoresPrimos (/ x (menorFatorPrimo x))))))

(comment "4. Utilizando  a  linguagem  Clojure,  crie  uma  função chamada  todosPrimos  que  receba  dois valores inteiros e devolve todos os números primos que existam entre estes dois valores.")

(defn todosPrimos [x y]
  (if (> x y) (todosPrimos y x)
      (filter ehPrimo (range x (inc y)))))



(println "Func. ehPrimo; entrada: 12; resultado: " (ehPrimo 12))
(println "Func. ehPrimo; entrada: 11; resultado: " (ehPrimo 11))
(println "Func. ehPrimo; entrada:  3; resultado: " (ehPrimo 3))
(println "Func. ehPrimo; entrada:  4; resultado: " (ehPrimo 4))

(println "Func. fatoresPrimos; entrada: 110; resultado: " (fatoresPrimos 110))
(println "Func. fatoresPrimos; entrada: 50; resultado: " (fatoresPrimos 50))
(println "Func. fatoresPrimos; entrada: 330; resultado: " (fatoresPrimos 330))

(println "Func. todosPrimos; entrada:1, 17; resultado: " (todosPrimos 1 17))
(println "Func. todosPrimos; entrada:5, 29; resultado: " (todosPrimos 5 29))
(println "Func. todosPrimos; entrada:22, 555; resultado: " (todosPrimos 22 55))
