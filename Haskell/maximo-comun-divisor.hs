-- maximo comun divisor entre dos números

mcd a 0 = a 
mcd a b = mcd b (mod a b)

main = print(mcd 5 15)