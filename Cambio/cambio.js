const url = 'https://www.dolarsi.com/api/api.php?type=valoresprincipales';

const https = require("https");
let obj = "";
https.get(url, (res) => {
    const {statusCode} = res;
    const contentType = res.headers['content-type'];
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
        res.resume();
        return;
    }

    res.setEncoding('utf8');
    let rawData = '';
    res.on('data', (chunk) => {
        rawData += chunk;
    });
    let pdata = '';
    res.on('end', () => {
        try {
            const parsedData = JSON.parse(rawData);
            let listaMenu = mostrarMenu(parsedData);
            mostrarMenu(listaMenu);

        } catch (e) {
            console.error(e.message);
        }
    });
}).on('error', (e) => {
    console.error(`Got error: ${e.message}`);
});

function mostrarMenu(jsonArray) {
    let lista = [];
    let jsonArray2 = [...jsonArray];

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
    let mayor = jsonArray2[0].casa.nombre.length;

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
    let mayorCompra = jsonArray2[0].casa.compra.length;

    for (let i = 0; i < jsonArray.length; i++) {
        let lista1 = [];
        let obj = jsonArray[i];
        let casa = obj.casa;
        let nombre = casa.nombre;
        let venta = casa.venta;
        let compra = casa.compra;
        let itemValido= 0;

        if (compra === ("No Cotiza")){
            continue;
        }

        let diff = mayor - nombre.length;
        let nombreSpacio = nombre + " ".repeat(diff) ;
        let diffCompra = mayorCompra - compra.length;
        let compraSpacio = compra + " ".repeat(diffCompra) ;




        if (compra === "No Cotiza"){
            continue;
        }

        itemValido++;

        lista1.push(nombre);
        lista1.push(venta);
        lista1.push(compra);
        lista.push(lista1);
        console.log(itemValido + " - " + nombreSpacio + " | " + "Compra : $ " + compraSpacio + " | " + "Venta : $ " + venta);

    }
   return lista;
}

function cambio(listaMenu){



}

