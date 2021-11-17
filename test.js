let str = "cadena";
let str_vacio = "";
let num = 35;
let num2 = 35.0;
let booleano_v = true;
let booleano_f = false;
let nulo = null;
let indefinido = undefined;
//'1', '2' '4'., '5', '6', '7', '8',
if (str){
    console.log('1');
}
if (num == num2){
    console.log('2');
}
if ( booleano_v && booleano_f) {
    console.log('3');
}
if (booleano_v && booleano_v) {
    console.log('4');
}
if (booleano_f || booleano_v) {
    console.log('5');
}
if (booleano_v || booleano_f) {
    console.log('6');
}
if (nulo || num) {
    console.log('7');
}
if (booleano_v && booleano_v || booleano_f ) {
    console.log('8');
}
if ( booleano_f || booleano_v && booleano_f) {
    console.log('9');
}
if (nulo || indefinido) {
    console.log('10');
}
if (str_vacio) {
    console.log('11');
}
//,b4,a1,c9, a2,b5, a3, c8,a4, b6, a5,c7 , a6, b7, a7,
let a = 0;
let b = 3;
let c = 10;
while ( b < c ) {
    if ( a % 2 == 0 ) {
        b++;
    } else {
        c--;
    }
    a++;
}

console.log(b);
console.log(c);