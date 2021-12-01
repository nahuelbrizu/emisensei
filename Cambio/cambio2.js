function traer(){
    fetch('https://www.dolarsi.com/api/api.php?type=valoresprincipales')
        .then(data => data.json())
        .then(data => {
           let lista = mostrarMenu(data);
           console.log(lista);
        });
}

function mostrarMenu(dataRecib){
    let monedas = [];
    for (let i = 0; i < dataRecib.length; i++){
        let obj = dataRecib[i];
        let casa = obj.casa;
        let nombre = casa.nombre;
        let compra = casa.compra;
        let venta = casa.venta;
        let lista=[];
        lista.push(nombre);
        lista.push(compra);
        lista.push(venta);
        monedas.push(lista);
        document.write(nombre, compra, venta);
    }
    return monedas;
}