-- menor entre dos numeros

menor :: Int -> Int -> Int

menor a b = if a < b
then a 
else b

main = print(menor 4 3)