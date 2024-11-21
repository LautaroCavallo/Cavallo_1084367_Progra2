Trabajo Práctico 5 –Árbol Binario de Búsqueda Balanceado (AVL) y Árbol B.

Árbol AVL

Ejercicio 1.

El árbol (a) no cumple con la propiedad AVL. Se puede balancear el nodo 32 con una rotación derecha simple.
Pasos para el balanceo:
 - Mover 25 a la posición de 32.
 - 32 se convierte en el hijo derecho de 25.
 - 27 se convierte en el hijo izquierdo de 32.

El árbol (b) sí cumple con la propiedad AVL y está balanceado correctamente.

Ejercicio 2.

a) Insertar 28: No requiere rotación, el árbol sigue siendo AVL.
El valor 28 se insertará como hijo derecho de 25, ya que es mayor que 25 pero menor que 32.

b) Insertar 47: No requiere rotación, el árbol sigue siendo AVL.
El valor 47 se insertará como hijo derecho de 45, ya que es mayor que 45 pero menor que 48.

c) Insertar 84: Requiere una rotación izquierda simple sobre el nodo 78 para restaurar la propiedad AVL.
  - El valor 84 se insertará como hijo derecho de 82, ya que es mayor que 82.
  - El nodo 78 tiene un subárbol derecho con altura 2 (raíz en 82 y luego 84).
  - Su subárbol izquierdo tiene una altura de 0, lo que provoca una diferencia de 2 en 78, no cumple con la propiedad AVL.
  - Se requiere una rotación izquierda simple sobre el nodo 78.

Realizar una rotación izquierda simple sobre 78:
  - El nodo 82 se convierte en la nueva raíz del subárbol.
  - El nodo 78 se convierte en el hijo izquierdo de 82.
  - El nodo 84 se mantiene como el hijo derecho de 82.

Ejercicio 3.
Árbol (a) es un árbol B.
Árbol (b) y árbol (c) no son árboles B debido a que no cumplen la propiedad de tener todas las hojas al mismo nivel.
  - Los nodos hojas no están al mismo nivel (el subárbol izquierdo tiene cuatro elementos mientras que otros subárboles tienen menos).
  - Similar al árbol (b), los nodos hojas no están al mismo nivel (el subárbol izquierdo tiene nodos adicionales).
   
Ejercicio 4.
  - Inserción del 67 requiere una división de nodos y la promoción del valor 57. La inserción de 32 no requiere reestructuración adicional.
  - El valor 67 debe insertarse en la hoja donde se encuentra el rango adecuado, es decir, en el nodo con los valores 49, 52, 57, 60.

Después de insertar 67, el nodo queda con 49, 52, 57, 60, 67, lo cual supera la capacidad máxima de claves permitidas en un nodo.

Para mantener el árbol B, este nodo debe dividirse:

El nodo 49, 52, 57, 60, 67 se divide en dos nodos:
49, 52
60, 67
El valor 57 se promueve al nodo raíz.
                  13,   21,   45,   57
               /     /   |   |    \     \
         7,8,10 14,17  22,24 30,32 49,52  60,67

Ejercicio 5.
  - La eliminación de 45 implica promover el valor 49 para mantener la estructura del árbol B.

El valor 45 se encuentra en el nodo raíz.

Al eliminar 45, debemos reorganizar el árbol para mantener las propiedades del árbol B.

Reorganización:

Se puede promover el valor 49 desde la hoja que contiene 49, 60 para reemplazar 45.

La hoja que tenía 49, 60 quedará con 60.

La estructura del árbol después de la eliminación quedará así:
              13, 21, 49
             /   |   |   \
         7,8,10 14,17 22,24,30 32, 60
