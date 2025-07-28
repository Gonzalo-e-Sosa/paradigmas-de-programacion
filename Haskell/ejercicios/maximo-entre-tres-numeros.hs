-- maximo entre tres numeros

maximo :: Int -> Int -> Int

maximo a b = if a > b
then a
else b

maximoDeTres :: Int -> Int -> Int -> Int

maximoDeTres a b c = if a > b
then maximo a c
else maximo a b

main = print(maximoDeTres 9 122 5)