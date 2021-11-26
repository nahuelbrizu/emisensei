let cantidadDolares;
let cantidadPesos;
let compraVenta;
let prompt = require('prompt-sync')();


console.log(" Ha Seleccionado " + ": "  +
    " | " + " Valor Compra : "  + " | " + " Valor Compra : " com);

do {
    compraVenta = prompt("Desea comprar o vender ? ", " ");
    if (compraVenta === "comprar"){
        cantidadPesos = prompt("cuantos pesitos desea transformar a dolarucos : ", " ");
        let dolar = cantidadPesos / compraSeleccion;
        console.log("conversion " + cantidadPesos + "pesitos " + dolar + "dolares");
    }
    if (compraVenta === "vender"){
        cantidadDolares = prompt(" Cuantos Dolarucos le interesa Vender : ", " ");
        let pesos = cantidadDolares * ventaSeleccion;
        console.log("conversion " + cantidadDolares + "dolares" + pesos + "Pesos");
    }
}
while (!compraVenta === "comprar" && !compraVenta === "vender");
console.log("llega a seleccion");

