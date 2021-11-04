function promedio (num1, num2) {
    let suma = num1 + num2;
    let prom = suma / 2;
    return prom;
}
function promedio_arr(array) {
 let sumando = 0;
    for (i = 0; i < array.length; i++) {
        let numero = array[i];
        sumando += numero;
    }
    return sumando / array.length ;
}
console.log(promedio(2, 3));
console.log(promedio(3, 5));
console.log(promedio(7, 6));
console.log(promedio(8, 3));

let pares = [[2, 3], [3, 5], [7, 6], [8,3]];
function promedios(array){
    let resultado = []
    for (let i = 0; i < array.length; i++) {
        let par = array[i];
        resultado.push(promedio_arr(par));
    }
        return resultado;
}
console.log(promedios(pares));