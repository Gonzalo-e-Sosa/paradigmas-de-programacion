-- determinar si la lista está ordenada de forma ascendente

esAscendente :: [Int] -> Bool
esAscendente [] = True
esAscendente [x] = True
esAscendente (x:y:xs) = x <= y && (esAscendente xs)

lst = [1,2,3,4,5,6,7,6,4]

main = print(esAscendente lst)