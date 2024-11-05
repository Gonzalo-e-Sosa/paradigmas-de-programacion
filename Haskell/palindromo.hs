-- es palíndromo 

esPalindromo :: String -> Bool
esPalindromo [] = True
esPalindromo [x] = True
esPalindromo (x:xs) = x == (last xs) && esPalindromo(init xs) 


p = "tet"
main = print(esPalindromo p)