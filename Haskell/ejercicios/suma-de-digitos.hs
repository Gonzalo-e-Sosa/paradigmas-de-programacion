-- calcular la suma de los dígitos de un número
-- ejemplo: 13 -> 1 + 3 = 4

sumaDeDigitos :: Int -> Int
sumaDeDigitos 0 = 0
sumaDeDigitos n = sumaDeDigitos(div n 10) + mod n 10
 
main = print(sumaDeDigitos 113313)