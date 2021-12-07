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
    let nombre = elemento;
    let compra = elemento[1];
    let venta = elemento[2];
    let cont = document.querySelector("#contenido");

    let divNombre = document.createElement('div');
    let textNombre = document.createTextNode(nombre);
    divNombre.appendChild(textNombre);
    cont.appendChild(divNombre);
    divNombre.addEventListener("click",function() { seleccion(elemento , " ") });

    let divCompra = document.createElement('div');
    let texCompra = document.createTextNode(compra);
    divCompra.appendChild(texCompra);
    cont.appendChild(divCompra)
    divCompra.addEventListener("click", function() { seleccion(elemento) });


    let divVenta = document.createElement('div');
    let textVenta = document.createTextNode(venta);
    divVenta.appendChild(textVenta);
    cont.appendChild(divVenta);
    divVenta.addEventListener("click", function() { seleccion(elemento) });


}


function seleccion(cambioElegido) {
    console.log(cambioElegido);
    let nombresSeleccion = cambioElegido[0];
    let ventaSeleccion = cambioElegido[1].replace(",", ".");
    let compraSeleccion = cambioElegido[2].replace(",", ".");
    console.log(nombresSeleccion);
    let compraVenta;
    let cantidadPesos;
    let cantidadDolares;



}

