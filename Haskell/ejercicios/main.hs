-- fibonacci
fibonacci :: Int -> Int
fibonacci 0 = 0
fibonacci 1 = 1
fibonacci n = fibonacci(n - 1) + fibonacci(n - 2)

multiplica :: [Int] -> [Int]
multiplica [] = []
multiplica (x:xs) = (x*x) : (multiplica xs) 

contarPares :: [Int] -> Int
contarPares [x] = if even x then 1 else 0
contarPares (x:xs) = contarPares([x]) + contarPares(xs) 

sumarPares :: [Int] -> Int
sumarPares [x] = if even x then x else 0
sumarPares (x:xs) = sumarPares([x]) + sumarPares(xs)

esPar :: Int -> Int
esPar x = if x `mod` 2 == 0 then 1 else 0

contarNotables :: (Int -> Int) -> [Int] -> Int
contarNotables f [] = 0
contarNotables f (x:xs) = (f x) + contarNotables f xs

-- zip [10,9,3,4,5] [1,8,2,3,4] -> [(10,1),(9,8),(3,2),(4,3),(5,4)]
-- foldr (+) 0 [10,9,3,4,5] -> 31
-- filter even [10,9,3,4,5] -> [10, 4]
-- map (3*) [10,9,3,4,5] -> [30,27,9,12,15]

-- Obtener pormedio de lista (Cuidado con el CERO!)

longitudLista :: [Int] -> Int
longitudLista [] = 0
longitudLista (x:xs) = 1 + longitudLista xs

totalLista :: [Int] -> Int
totalLista [] = 0
totalLista (x:xs) = x + totalLista xs

obtenerPromedio :: [Int] -> Int
obtenerPromedio [] = 0
obtenerPromedio [x] = x
obtenerPromedio x = totalLista x `div` longitudLista x
 
numerosPares :: [Int] -> [Int]
numerosPares [] = []
numerosPares [x] = if even x then [x] else []
numerosPares (x:xs) = (numerosPares [x])++(numerosPares xs)

main = print(numerosPares [])