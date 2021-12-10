function formulario(){
    var str = ((document.getElementById("cal_preview")||{}).value)||"";

    var nombre = ((document.getElementById("nombre")||{}).value)||"";
        console.log(nombre);
    document.getElementById("respuest").innerHTML = nombre ;
}

function traer() {
    fetch('https://www.dolarsi.com/api/api.php?type=valoresprincipales')
        // let lista = mostrarMenu(data.json()) evitando usar la linea de abajo
        .then(data => data.json())
        .then(data => {
            let lista = gererarLista(data);
            mostrarMenu(lista);
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

    lista.forEach((elemento, index ) => {
        agregarItemAlContenedor(elemento, index)
    })
}

function agregarItemAlContenedor(elemento){
    let nombre = elemento[0];
    let compra = elemento[1];
    let venta = elemento[2];

    let moneda= document.getElementById("moneda").innerHTML= "Moneda"
    let compraIndex= document.getElementById("compra").innerHTML= "Compra"
    let ventaIndex = document.getElementById("venta").innerHTML= "Venta"


    let cont = document.createElement("tr");
    let padre = document.querySelector("#tabla");


    let divNombre = document.createElement('th');
    let textNombre = document.createTextNode(nombre);
    divNombre.appendChild(textNombre);
    cont.appendChild(divNombre);

    let divCompra = document.createElement('td');
    let textCompra = document.createTextNode(compra);
    divCompra.appendChild(textCompra);
    cont.appendChild(divCompra)
    divCompra.addEventListener("click", function(e) {
        seleccion(elemento, e.currentTarget,true)

    });


    let divVenta = document.createElement('td');
    let textVenta = document.createTextNode(venta);
    divVenta.appendChild(textVenta);
    cont.appendChild(divVenta);
    divVenta.addEventListener("click", function(e) {
        seleccion(elemento, e.currentTarget, false)


    });
    padre.appendChild(cont);

}



function seleccion(cambioElegido, elementoClickeado, compra) {

    let nombresSeleccion = cambioElegido[0];
    let compraSeleccion = cambioElegido[1];
    let ventasSeleccion = cambioElegido[2];

    let seleccionActual = document.querySelector('.seleccionado');
    if (seleccionActual){
        seleccionActual.classList.remove("seleccionado");
    }
    elementoClickeado.classList.add("seleccionado");

        let mensaje = document.querySelector("#mensaje");
        mensaje.removeChild(cam)
    console.log(nombresSeleccion, compraSeleccion,ventasSeleccion)

    // let mensaje = document.querySelector("#mensaje");
    // mensaje.innerHTML = ""
    // mensaje.appendChild(document.createTextNode('bla2'))
    // "bla2"
    // mensaje.innerHTML = ""




}

function conversor(){
    console.log("jeje");
}


