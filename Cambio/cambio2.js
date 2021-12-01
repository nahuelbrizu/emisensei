//fetch = ir a busca....then = luego
traer();

function traer() {
    fetch('https://www.dolarsi.com/api/api.php?type=valoresprincipales')
        .then(data => data.json())
        // let lista = mostrarMenu(data.json()) evitando usar la linea 4
        .then(data => {
            let lista = gererarLista(data);
            mostrarMenu(lista);
            let numElegido = elegirCambio(lista);
            let cambioElegido = seleccion(numElegido);

        });
}

function gererarLista(dataRecib) {
    let monedas = [];
    for (let i = 0; i < dataRecib.length; i++) {
        let obj = dataRecib[i];
        let casa = obj.casa;
        let nombre = casa.nombre;
        let compra = casa.compra;
        let venta = casa.venta;
        if (compra === "No Cotiza" || venta === "No Cotiza") {
            continue;
        }
        let lista = [];
        lista.push(nombre);
        lista.push(compra);
        lista.push(venta);
        monedas.push(lista);
    }
    return monedas;
}

function mostrarMenu(lista) {

    let array = [...lista];
    array.sort((a, b) => {
        if (a[0].length < b[0].length) {
            return 1;
        }
        if (a[0].length > b[0].length) {
            return -1;
        } else {
            return 0;
        }
    });
    let nombreMasLargo = array[0][0].length;

    array.sort((a, b) => {
        if (a[1].length < b[1].length) {
            return 1;
        }
        if (a[1].length > b[1].length) {
            return -1;
        } else {
            return 0;
        }
    });
    let compraMasLargo = array[0][1].length;

    array.forEach((elemento, itemNum) => {
        let itemNumerico= itemNum + 1;
        let nombre = elemento[0];
        let compra = elemento[1];
        let venta = elemento[2];
        let differenciaDeLongitudName = nombreMasLargo - nombre.length;
        let differenciaDeLongitudCompra = compraMasLargo - compra.length;
        let nombreConEsp = nombre + "_".repeat(differenciaDeLongitudName);
        let compraConEsp = compra + " ".repeat(differenciaDeLongitudCompra);
        let ventaConEsp = venta + " ";
        document.write(itemNumerico + "  |  " + nombreConEsp + "  |  " + compraConEsp + "  |  " + ventaConEsp + "<br>");
        console.log(itemNumerico + "  |  " + nombreConEsp + "  |  " + compraConEsp + "  |  " + ventaConEsp);
    })
}

function elegirCambio(menu) {
    let isInvalid;
    let cambio = 0;

    do {
        cambio = prompt(" Seleccione el numer de cambio : ");
        try {
            isInvalid = cambio < 1 || cambio > menu.length || isNaN(cambio);

        } catch (e) {
            isInvalid = true;
        }
        if (isInvalid) {
            document.write(" Eso no es un cambio Chamaco.. ingrese un cambio..");
        }
    } while (isInvalid) ;

    let arrayCambioElegido = menu[cambio - 1];
    let nombresSeleccion = arrayCambioElegido[0];
    let compraSeleccion = arrayCambioElegido[1];
    let ventaSeleccion = arrayCambioElegido[2];
    console.log(" Ha Seleccionado " + ": " + nombresSeleccion +
        " | " + " Valor Compra : " + compraSeleccion + " | " + " Valor Venta : " + ventaSeleccion);
    document.write(" Ha Seleccionado " + ": " + nombresSeleccion +
        " | " + " Valor Compra : " + compraSeleccion + " | " + " Valor Venta : " + ventaSeleccion + "<br>");
    return arrayCambioElegido;
}

function seleccion(cambioElegido) {

    let nombresSeleccion = cambioElegido[0];
    let compraSeleccion = cambioElegido[1].replace(",", ".");
    let ventaSeleccion = cambioElegido[2].replace(",", ".");
    let compraVenta;
    let cantidadPesos;
    let cantidadDolares;

    do {
        compraVenta = prompt("Desea comprar o vender ? ", "comprar");
        if (compraVenta === "comprar") {
           cantidadPesos = prompt("cuantos pesitos desea transformar a dolarucos : ", "1000");
            let dolar = cantidadPesos / compraSeleccion;
            console.log("conversion  " + nombresSeleccion + " Pesitos " + "lo transformas a " + cantidadPesos + " Dolares : " + dolar);
            document.write("conversion  " + nombresSeleccion + " Pesitos " + cantidadPesos + "lo transformas a " + " Dolares : " + dolar);
            document.write("<br>")
        }
        if (compraVenta === "vender") {
            cantidadDolares = prompt(" Cuantos Dolarucos le interesa Vender : ", "1000 ");
            let pesos = cantidadDolares * ventaSeleccion;
            console.log("conversion  " + " Dolares :" + "Lo transformas a " + cantidadDolares + " " + " Pesos : " + pesos);
            document.write("conversion" + nombresSeleccion + " : " + " ingreso "+ " : "  + cantidadDolares + "se Convierte a pesos " + pesos);

        }
    }
    while (compraVenta !== "comprar" && compraVenta !== "vender");

}
