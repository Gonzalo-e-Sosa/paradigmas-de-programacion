-- obtener elementos en posiciones pares de una lista

obtenerElementosEnPosicionesPares :: [Int] -> [Int]
obtenerElementosEnPosicionesPares [] = []
obtenerElementosEnPosicionesPares [x] = [x]
obtenerElementosEnPosicionesPares (x:_:xs) = x:obtenerElementosEnPosicionesPares xs 

lst = [1,2,3,4,5,6,7,6,4]

main = print(obtenerElementosEnPosicionesPares lst)