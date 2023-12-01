import os
import re

primerNumero = []
segundoNumero = []
suma = []
resultado = 0
filePath = os.path.join(os.path.dirname(os.path.abspath(__file__)), 'firstInput.txt')

def Day1(filePath):
    try:
        with open(filePath, 'r') as file:
            for line in file:
                codigo = []
                codigo = re.split('\B', line)
                print (codigo)
                for num in codigo:
                    num = num.split('\n')[0]
                    if num.isdigit() == False:
                        continue
                    if num.isdigit() == True:
                        primerNumero.append(num)
                    break
                for num in reversed(codigo):
                    num = num.split('\n')[0]
                    if num.isdigit() == False:
                        continue
                    if num.isdigit() == True:
                        segundoNumero.append(num)
                    break
    except FileNotFoundError:
            print(f"No se encuentra el archivo {filePath}")

if __name__ == '__main__':
    Day1(filePath)

    contador = 0  

    for num in primerNumero:
        suma.append(primerNumero[contador] + segundoNumero[contador])
        contador += 1

    contador = 0

    for num in suma:
        resultado += int(suma[contador])
        contador += 1
    print(resultado)