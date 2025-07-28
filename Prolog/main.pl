saludar :- write('Hola desde Prolog en Docker!'), nl.

% Los hechos y reglas de Prolog se definen como pares clave-valor,
% donde los hechos son afirmaciones y las reglas son inferencias basadas en esos hechos.
% Ambos son llamados cláusulas.

% Hechos
padre_de(pedro, juan).
padre_de(pedro, ana).
padre_de(luca, pedro).
padre_de(luca, timoteo).

madre_de(maria, ana).
madre_de(maria, juan).

% Reglas
progenitor_de(X, Y):- madre_de(X, Y).
progenitor_de(X, Y):- padre_de(X, Y).

% Recursividad para encontrar antecesores
antecesor_de(X, Y):- padre_de(X, Y).
antecesor_de(X, Y):- padre_de(X, Z), antecesor_de(Z, Y).

% Relación inversa
hijo_de(X, Y):- progenitor_de(Y, X).

hermano_de(X, Y):- 
    progenitor_de(Z, X),
    progenitor_de(Z, Y),
    X \= Y,  % Al final porque al principio la variable "Y" no está definida
    X @< Y.  % Para evitar duplicados

% Operador "is", usado para asignar variables o comparar
% en Prolog, los parámetros permiten retornar valores ya que las reglas retornar "true" o "false"
sumar(X, Y, Z):- Z is X + Y.

factorial(0, 1). % Caso base: el factorial de 0 es 1
factorial(N, R):- 
    N > 0, % Aseguramos que N sea positivo
    N1 is N - 1, % Asignamos N1 como N - 1
    factorial(N1, R1), % Llamada recursiva al factorial
    R is R1 * N. % Asignamos R como R1 * N

% Listas y operaciones con listas
% Las listas en Prolog son estructuras de datos que pueden contener elementos de cualquier tipo.
% Se definen con corchetes y los elementos se separan por comas.
% Ejemplo de lista: [1, 2, 3, 4]
% Para definir una lista vacía, se usa [].
% Para acceder a los elementos de una lista, se usa el operador "|", que separa la cabeza de la cola.
% Ejemplo: [Cabeza|Cola] representa una lista donde "Cabeza" es el primer elemento y "Cola" es el resto de la lista.

% Pertenencia de un elemento en una lista
pertenece([]):- fail. % "fail" es un predicado que siempre falla, aca es usado para indicar que la lista está vacía.
pertenece([Ca|_], Ca).
pertenece([_|Co], E):- pertenece(Co, E).

% Contar elementos de una lista
contar([], 0).
contar([_|Co],C):-
    contar(Co, CC),
    C is CC + 1.

% Concatenar dos listas
% La concatenación de listas en Prolog se realiza uniendo los elementos de dos listas en una sola lista.
% La regla "concatenar" toma dos listas y produce una tercera lista
% que es la combinación de las dos primeras.
% La regla se define de manera recursiva, donde la cabeza de la primera lista se
% agrega a la cabeza de la lista resultante, y luego se concatena el resto de
% la primera lista con la segunda lista.
% La regla también maneja casos especiales, como cuando una de las listas es vacía.
concatenar([], [], []).
concatenar([], L, L).
concatenar(L, [], L).
concatenar([Ca|Co], L2, [Ca|Co3]):- % La cabeza de la primera lista se agrega a la cabeza de la lista resultante
    concatenar(Co, L2, Co3). % Llamada recursiva para concatenar el resto de la lista

% empleado(nombre, cargo, salario, departamento)
empleado("Juan", "Ingeniero", 1300000, "IT").
empleado("Luca", "Ingeniero", 1200000, "IT").
empleado("Gonzalo", "Ingeniero", 1100000, "IT").
empleado("Francisco", "Ingeniero", 1400000, "IT").
empleado("Pedro", "Comerciante", 900000, "Ventas").
empleado("Momo", "Abogado", 1000000, "RRHH").
empleado("Maria", "Junior", 1040000, "RRHH").

obtener_empleados_departamento(Departamento, Empleados):-
    findall(E, empleado(E, _, _, Departamento), Empleados).

obtener_empleados_salario_mayor(Salario, Empleados):-
    findall(Empleado, (empleado(Empleado, _, S, _), S >= Salario), Empleados).


% Ejercicio tipo parcial

% Base de Conocimientos: Temperaturas Mínimas y Máximas por Ciudad y Día

% --- Hechos para temperaturas mínimas ---
% Sintaxis: temperatura_minima(Ciudad, DiaDeLaSemana, Temperatura).

% Londres
temperatura_minima("Londres", "Lunes", 10).
temperatura_minima("Londres", "Martes", 14).
temperatura_minima("Londres", "Miercoles", 12).
temperatura_minima("Londres", "Jueves", 11).
temperatura_minima("Londres", "Viernes", 13).
temperatura_minima("Londres", "Sabado", 15).
temperatura_minima("Londres", "Domingo", 10).

% Buenos Aires
temperatura_minima("Buenos_Aires", "Lunes", 18).
temperatura_minima("Buenos_Aires", "Martes", 20).
temperatura_minima("Buenos_Aires", "Miercoles", 19).
temperatura_minima("Buenos_Aires", "Jueves", 17).
temperatura_minima("Buenos_Aires", "Viernes", 16).
temperatura_minima("Buenos_Aires", "Sabado", 15).
temperatura_minima("Buenos_Aires", "Domingo", 18).

% Tokyo
temperatura_minima("Tokyo", "Lunes", 22).
temperatura_minima("Tokyo", "Martes", 23).
temperatura_minima("Tokyo", "Miercoles", 21).
temperatura_minima("Tokyo", "Jueves", 20).
temperatura_minima("Tokyo", "Viernes", 24).
temperatura_minima("Tokyo", "Sabado", 25).
temperatura_minima("Tokyo", "Domingo", 22).

% --- Hechos para temperaturas máximas ---
% Sintaxis: temperatura_maxima(Ciudad, DiaDeLaSemana, Temperatura).

% Londres
temperatura_maxima("Londres", "Lunes", 18).
temperatura_maxima("Londres", "Martes", 22).
temperatura_maxima("Londres", "Miercoles", 20).
temperatura_maxima("Londres", "Jueves", 19).
temperatura_maxima("Londres", "Viernes", 21).
temperatura_maxima("Londres", "Sabado", 23).
temperatura_maxima("Londres", "Domingo", 18).

% Buenos Aires
temperatura_maxima("Buenos_Aires", "Lunes", 28).
temperatura_maxima("Buenos_Aires", "Martes", 30).
temperatura_maxima("Buenos_Aires", "Miercoles", 29).
temperatura_maxima("Buenos_Aires", "Jueves", 27).
temperatura_maxima("Buenos_Aires", "Viernes", 26).
temperatura_maxima("Buenos_Aires", "Sabado", 25).
temperatura_maxima("Buenos_Aires", "Domingo", 28).

% Tokyo
temperatura_maxima("Tokyo", "Lunes", 30).
temperatura_maxima("Tokyo", "Martes", 31).
temperatura_maxima("Tokyo", "Miercoles", 29).
temperatura_maxima("Tokyo", "Jueves", 28).
temperatura_maxima("Tokyo", "Viernes", 32).
temperatura_maxima("Tokyo", "Sabado", 33).
temperatura_maxima("Tokyo", "Domingo", 30).

temperatura_promedio(D, R):-
    temperatura_minima(_, D, T1),
    temperatura_maxima(_, D, T2),
    T3 is T1 + T2,
    R is T3 / 2.

calcular_promedio_minima(Dia, 0):-
    findall(Temp, temperatura_minima(_, Dia, Temp), ListaTemperaturas),
    ListaTemperaturas = [].

calcular_promedio_minima(Dia, Promedio):-
    findall(Temp, temperatura_minima(_, Dia, Temp), ListaTemperaturas),
    ListaTemperaturas \= [],
    sum_list(ListaTemperaturas, Suma),
    length(ListaTemperaturas, Cantidad),
    Promedio is Suma / Cantidad.
    
minima_temperatura_promedio(Promedia, Dia):-
    calcular_promedio_minima(Dia, Promedio).    
