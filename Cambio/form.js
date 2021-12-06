function formulario(){
    var str = ((document.getElementById("cal_preview")||{}).value)||"";

    var nombre = ((document.getElementById("nombre")||{}).value)||"";
        console.log(nombre);
// mostrar informarcion en elemnet id
    document.getElementById("respuest").innerHTML = nombre ;
}