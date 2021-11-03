// let num = 0;
// let count = 0;
// let j = 2;
// let i;
// let primo = [];
// let lista = [];
// let pares = [];
// let impares = [];
//
// while ( num < 100 ){
//     num++;
//     count++;
//     lista.push(num);
// }
// for (i = 0; i < lista.length; i++) {
//     let numero = lista[i];
//     if (numero % 2 != 1) {
//        pares.push(numero);
//     } else {
//         impares.push(numero);
//     }
//     for (j = 2; j <= numero - 1; j++) {
//         let resto = numero % j;
//         if (resto == 0){
//             break;
//         }
//         if (j == numero - 1){
//             primo.push(numero);
//         }
//     }
// }
//
// console.log(lista);
// console.log(impares);
// console.log(pares);
// console.log(primo);
// crear array de resultado
// recorrer la lista
// por cada numero N:
//     recorrer desde J: 2 hasta N - 1
//         sacar el resto del numero N / J
//         si ese resto es 0 -> break
//         si ese resto no es 0 -> continue
//         si J == N -1 push al array de resultado
//
// imprimir array de resultado


let lista = ['A', 'B', 'C', 'D'];
let lista2 = [];
let combinadorLetras = [];
let s;

    function combinador(lista) {
        let resultados = [];
        for (let s = 0; s < lista.length; s++) {
            let letra = lista[s];
            let letrasRestantes = lista.filter(function(item){return item != letra});
            for (let lr = 0; lr < letrasRestantes.length; lr++){
                let letraB = letrasRestantes[lr];
                let str = letra + letraB;
                let lRestanteB = letrasRestantes.filter(function(item){return item != letraB})
                for (let lrb = 0; lrb < lRestanteB.length; lrb++){
                    let letraC = lRestanteB[lrb];
                    let lRestanteC = lRestanteB.filter(function(item){return item != letraC})
                    let resultado = str + letraC + lRestanteC.pop();
                    resultados.push(resultado);
                }
            }
        }
        return resultados;
    }
    console.log(combinador(lista));
//
// recorrer la lista
// por cada letra LETRA RECORRIDA