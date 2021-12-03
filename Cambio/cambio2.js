//fetch = ir a busca....then = luego
//traer();
// busca un elemento con el parametro..
// creo un elemento con

// "bla"
//var node = document.createElement("LI");                 // Create a <li> node
// var textnode = document.createTextNode("Water");         // Create a text node
// node.appendChild(textnode);                              // Append the text to <li>
// document.getElementById("myList").appendChild(node);     // Append <li> to <ul> with id="myList"
function traer() {
    fetch('https://www.dolarsi.com/api/api.php?type=valoresprincipales')
        .then(data => data.json())
        // let lista = mostrarMenu(data.json()) evitando usar la linea de abajo
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
   //
   //  let array = [...lista];
   //
   // // agarro la variable (array) que contiene una copia de la lista para ordenarla.sort por las mayores longitudes
   //  array.sort((a, b) => {
   //      if (a[0].length < b[0].length) {
   //          return 1;
   //      }
   //      if (a[0].length > b[0].length) {
   //          return -1;
   //      } else {
   //          return 0;
   //      }
   //  });
   //  let nombreMasLargo = array[0][0].length;
   //
   //  array.sort((a, b) => {
   //      if (a[1].length < b[1].length) {
   //          return 1;
   //      }
   //      if (a[1].length > b[1].length) {
   //          return -1;
   //      } else {
   //          return 0;
   //      }
   //  });
   //  let compraMasLargo = array[0][1].length;
// aca recorro la lista original.. para procegir con el codigo..
    lista.forEach((elemento, index) => {
        agregarItemAlContenedor(elemento)

       // let itemNumerico  = 1 + itemNum;
       //
       //  let differenciaDeLongitudName = nombreMasLargo - nombre.length;
       //  let differenciaDeLongitudCompra = compraMasLargo - compra.length;
       //  let nombreConEsp = nombre + " ".repeat(differenciaDeLongitudName);
       //  let compraConEsp = compra + " ".repeat(differenciaDeLongitudCompra);
       //  let ventaConEsp = venta + " ";
        // console.log(itemNumerico + "  |  " + nombreConEsp + "  |  " + " $ " + compraConEsp + "  |  " + " $ "  + ventaConEsp);
    })
}
function agregarItemAlContenedor(elemento){
    let nombre = elemento[0];
    let compra = elemento[1];
    let venta = elemento[2];
    let cont = document.querySelector("#contenido");

    let divNombre = document.createElement('div');
    let textNombre = document.createTextNode(nombre);
    divNombre.appendChild(textNombre);
    cont.appendChild(divNombre);

    let divCompra = document.createElement('div');
    let texCompra = document.createTextNode(compra);
    divCompra.appendChild(texCompra);
    cont.appendChild(divCompra)

    let divVenta = document.createElement('div');
    let textVenta = document.createTextNode(venta);
    divVenta.appendChild(textVenta);
    cont.appendChild(divVenta);

}

 function elegirCambio(menu) {
    let isInvalid;
    let cambio = 0;

    do {
        cambio = prompt(" Seleccione el numero de cambio : ");
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
    let ventaSeleccion = cambioElegido[1].replace(",", ".");
    let compraSeleccion = cambioElegido[2].replace(",", ".");
    let compraVenta;
    let cantidadPesos;
    let cantidadDolares;

    do {
        compraVenta = prompt("Desea comprar o vender ? ", "comprar");
        if (compraVenta === "comprar") {
            cantidadPesos = prompt("cuantos" + nombresSeleccion + "Desea Comprar : ", "1000");
            let dolar = cantidadPesos * compraSeleccion;


            console.log("Desea convertir  " + nombresSeleccion + "lo transformas a "
                + cantidadPesos + " Dolares : " + dolar);
            document.write("_".padEnd(70, "_") +  "<br>");
            document.write("<br>")
            document.write("Selecciono Comprar");
            document.write("<br>")
            document.write("Ha Seleccionado : " + nombresSeleccion + " - " +
                "Ingreso  :  $" + cantidadPesos + " el cambio convertido es : " + dolar);
            document.write("<br>")
        }
        if (compraVenta === "vender") {
            cantidadDolares = prompt(" Cuantos" +nombresSeleccion+" le interesa Vender : ", "1000");
            let pesos = cantidadDolares / ventaSeleccion;
            document.write("_".padEnd(70, "_") +  "<br>");
            console.log("conversion  " + " Dolares :" + "Lo transformas a " + cantidadDolares + " " + " Pesos : " + pesos);
            document.write("<br>");
            document.write("Selecciono vender");
            document.write("<br>");
            document.write("Ha Seleccionado : " +  nombresSeleccion + " - " +
                "Ingreso  :  $" + cantidadDolares + " el cambio convertido es : " + pesos);
            document.write("<br>")
        }
    }
    while (compraVenta !== "comprar" && compraVenta !== "vender");

}


