const url = 'https://www.dolarsi.com/api/api.php?type=valoresprincipales';
const https = require("https");
let prompt = require('prompt-sync')();

// estoy definiendo una constante de nombre https a la cual le asigno como valor lo que devuelve la funcion require cuando recibe como parametro un string "htttps"


let obj = "";

function procesarResultado( resultado ) {
    const {statusCode} = resultado;
    //const statusCode = resultado.statusCode;
    //const codigoDeEstado = resultado.statusCode; // si quiero usar otro nombre de variable no puedo usar {} para definirla
    //const {codigoDeEstado} = resultado; // exception resultado.codigoDeEstado no existe const codigoDeEstado = resultado.codigoDeEstado;
    //STATUSCODE ES UNA PROPIEDAD //
    const {headers} = resultado;
    // const headers = resultado.headers;
    const contentType = headers['content-type'];
    let error;
    if (statusCode !== 200) {
        error = new Error('Request Failed.\n' +
            `Status Code: ${statusCode}`);
    } else if (!/^application\/json/.test(contentType)) {
        error = new Error('Invalid content-type.\n' +
            `Expected application/json but received ${contentType}`);
    }
    if (error) {
        console.error(error.message);
        // Consume response data to free up memory
        resultado.resume();
        return;
    }

    resultado.setEncoding('utf8');
    let rawData = '';
    resultado.on('data', (chunk) => {
        rawData += chunk;
    });
    let pdata = '';
    resultado.on('end', () => {
        try {
            const parsedData = JSON.parse(rawData);
            let listaMenu = mostrarMenu(parsedData);
            let cambioElegido = cambio(listaMenu)
            let numeroElegido = seleccion(cambioElegido);

        } catch (e) {
            console.error(e.message);
        }
    });
}

function procesarError(error){
    console.error(`Got error: ${error.message}`);
}

https.get(url, procesarResultado).on('error', procesarError);
//creo una funcion  Mostrarmenu dnd recorro el json para obtener una lista ordenada numericamente, para luego poder ser interseptada por el usuario.
function mostrarMenu(jsonArray) {
//defino una variable con valor de lista.
    let lista = [];
//defino una variablale con el valor d una lista obtenida del argumento de la func Mostrarmenu.
    let jsonArray2 = [...jsonArray];
// creo un condicional para medir el string con mas longitud.
    jsonArray2.sort((a, b)=>{
        if (a.casa.nombre.length < b.casa.nombre.length) {
            return 1
        }
        if (a.casa.nombre.length > b.casa.nombre.length) {
            return -1
        } else {
            return 0
        }
        });
    // defino una variable para guardar la longitud en nombre, obtenido del condicional anterior.
    let mayor = jsonArray2[0].casa.nombre.length;
//creo un condicional para medir la longitud de compra.
    jsonArray2.sort((a, b)=>{
        if (a.casa.compra.length < b.casa.compra.length) {
            return 1
        }
        if (a.casa.compra.length > b.casa.compra.length) {
            return -1
        } else {
            return 0
        }
    });
    // defino una variable para guardar la longitud de compra, obtenido del codicional anterior.
    let mayorCompra = jsonArray2[0].casa.compra.length;
// defino una variable itemVal para guardar y darle una numeracion al menu.
    let itemValido = 0;

    // creo un iterador for para reccorrer la lista jsonArray para obtener el nombre y los valores de compra y venta.  qu
    for (let i = 0; i < jsonArray.length; i++) {
       //defino lista1 con el valor de un array vacio. para ingresar nombre, venta y compra. y luego importarlos a la lista gral.
        let lista1 = [];
        // defino la variable obj para guardar el recorrido de la iteracion con los valores de nombre, compra y venta.
        let obj = jsonArray[i];
        //defino variables con el valor de los objetos en variables.
        let casa = obj.casa;
        let nombre = casa.nombre;
        let venta = casa.venta;
        let compra = casa.compra;

        /// creo un condicional para recorrer y separar los elementos en compra q no me sirven para hacer calculos matematicos.
        if (compra === ("No Cotiza")){
            continue;
        }
        // defino la variables diff y diffCompra para restar las variables de mayor(longitud) con la longitud de su nombre, para hacer donde la mayor longitud del nombre sea el parametro para medir los demas nombre.
        let diff = mayor - nombre.length;
        let diffCompra = mayorCompra - compra.length;
        // defino la variables para generar espacios en las variables usando como parametro las variables anteriores de longitud.
        let nombreSpacio = nombre + " ".repeat(diff) ;
        let compraSpacio = compra + " ".repeat(diffCompra);

// creo un condicional para recorrer y separar los elementos en compra o venta q no me sirven para hacer calculos matematicos.
        if (compra === "No Cotiza" || venta === "No Cotiza"){
            continue;
        }
        //llamo a lista1 para pushear nombre, venta y compra. para luego ingresarlas en la lista general.
        lista1.push(nombre);
        lista1.push(venta);
        lista1.push(compra);
        lista.push(lista1);
        // llamo a itemValido y le agrego uno por cada recorrido.
        itemValido++;
        // creo una impresion con las variables y string necesarios para ordenar mi menu.
        console.log(itemValido + " - " + nombreSpacio + " | " + "Compra : $ " + compraSpacio + " | " + "Venta : $ " + venta);
    }
    //fuera del iterador pero dentro de la func MostrarMenu devuelvo la lista.

    return lista;
}
// creo una funcion llamada cambio con el argumento de listaMenu numerico para poder ingresar datos del teclado.
function cambio(listaMenu) {

    let isInvalid;
    let cambio = 0;
    let prompt = require('prompt-sync')();

    do {
        cambio = prompt(" Seleccione el numer de cambio : ", " eje: 1 ");
        try {
            isInvalid = cambio < 1 || cambio > listaMenu.length || isNaN(cambio);

        } catch (e) {
            isInvalid = true;
        }
        if (isInvalid){
            console.log(" Eso no es un cambio Chamaco.. ingrese un cambio..");
        }
    } while (isInvalid) ;

    let arrayCambioElegido = listaMenu[cambio - 1];
    let nombresSeleccion = arrayCambioElegido[0];
    let compraSeleccion = arrayCambioElegido[1];
    let ventaSeleccion = arrayCambioElegido[2];
    console.log(" Ha Seleccionado " + ": " + nombresSeleccion +
        " | " + " Valor Compra : " + compraSeleccion + " | " + " Valor Venta : " + ventaSeleccion);
    return arrayCambioElegido;
}

//creo una funcion para  hacer un selector(x teclado) de la opcion compra y venta. ademas de realizar las operaciones matematicas cuando el usuario seleciona dichas opciones.
function seleccion(tipoDeCambio){
    // creo variables para alamacenar la informacion seleccionada e inputs del usuario
    let cantidadDolares;
    let cantidadPesos;
    let compraVenta;
    //defino variables para introducir los input del usuario
    let nombresSeleccion = tipoDeCambio[0];
    let compraSeleccion = tipoDeCambio[1].replace(",", ".");
    let ventaSeleccion = tipoDeCambio[2].replace(",", ".");

    // creo un condicional para q la vm pueda seleccionar las opciones que le doy. ademas realiza la operacion matematica del valor dolar o pesos.

    do{
        compraVenta = prompt("Desea comprar o vender ? ", " comprar ");
        if (compraVenta === "comprar"){
            cantidadPesos = prompt("cuantos pesitos desea transformar a dolarucos : ", " 1000 ");
            let dolar = cantidadPesos / compraSeleccion;
            console.log("conversion  " + " Pesitos " + "lo transformas a "+ cantidadPesos   + " Dolares : " + dolar);
        }
        if (compraVenta === "vender"){
            cantidadDolares = prompt(" Cuantos Dolarucos le interesa Vender : ", "1000 ");
            let pesos = cantidadDolares * ventaSeleccion;
            console.log("conversion  " + " Dolares :"+ "Lo transformas a " + cantidadDolares + " " + " Pesos : " + pesos);
        }
    }
    while (compraVenta !== "comprar" && compraVenta !== "vender");

}


