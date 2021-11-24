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
            mostrarMenu(parsedData);
        } catch (e) {
            console.error(e.message);
        }
    });
}).on('error', (e) => {
    console.error(`Got error: ${e.message}`);
});

function mostrarMenu(jsonArray) {
    let lista = [];
    let  lista1 = [];
    let itemsValidos;
    let letraMayLong;
    let letramenLong;
    for (let i = 0; i < jsonArray; i++) {
        let obj = jsonArray[i];
        let casa = obj.casa;
        let nombre = casa.nombre;
        let compra = casa.compra;
        let venta = casa.venta;

        if ((compra) === ("No Cotiza")) {
            continue;
        }
        if (nombre.length() > letraMayLong) {
            letraMayLong = nombre.length();
        }
        if (compra.length() > letramenLong) {
            letraMayLong = compra.length();
        }
        let diff = letraMayLong - nombre.length();
        let result = diff.replace("\0", " ");
        let nombreConEspacios = nombre + result;

        let diffCompra = letraMayLong - compra.length();
        let resulta2 = diffCompra.replace("\0", " ");
        let compraConEspacios = compra + resulta2;


        if ((compraStr).equals("No Cotiza")) {
            continue;
        }
        itemsValidos++;
        lista1.push(nombre);
        lista1.push(compra);
        lista1.push(venta);
        lista.push(lista1);
        console.log(itemsValidos + " - " + nombreConEspacios + " | " + " Compra : $ " + compraConEspacios + " | " + " Venta : $ " + ventaStr);
    }
    return lista;
}
console.log(mostrarMenu(jsonArray));