let usuarios = [ {
    nombre:"Nahuel",
    apellido: "Brizuela",
    edad: 29,
    nacionalidad: "Argentina",
    direccion: {
        calle: "san carlos",
        altura: 1392,
        barrio: "Santos Lugares"
    },
    hijos: ["Cogo", "Charly"] },

    {
    nombre:"carlitos",
    apellido: "estropito",
    edad: 59,
    nacionalidad: "Argentina",
    direccion: {
        calle: "sean carlos",
        altura: 292,
        barrio: "casonova"
    },
    hijos: ["samuel", "Carola", "ignacio"],

}, {
    nombre:"samuel",
    apellido: "Cazuela",
    edad: 89,
    nacionalidad: "brazil",
    direccion: {
        calle: "jsasd",
        altura: 1323,
        barrio: "Hurlingam"
    },
    hijos: ["elsa", "salamin", "juan", "rogelio"],

},
    {
    nombre:"cosme",
    apellido: "fulanito",
    edad: 29,
    nacionalidad: "peru",
    direccion: {
        calle: "san zaraza",
        altura: 322,
        barrio: "ituzaingo"
    },
    hijos: ["jacinto", "juana", "soldana", "salamanca"]

},
    {
        nombre: "roberta",
        Apellido: "lamas",
        edad: 40,
        nacionalidad: "venezolana",
        direccion: {
            calle: "santa florencia",
            altura: "123",
            barrio: "jean black"
        },
        hijos: ["esteban"]
    }
    ];

let contendor = [];
// let mayorQ40 = usuarios.forEach(function (usuario){
//     let numeros = usuario.nombre + " :" + usuario.edad;
//     contendor.push(numb));
//     console.log(numeros);
// });

let mayorQ400 = usuarios.filter(function (usuario) {
 return usuario.edad > 40;
});
console.log(mayorQ400)

let rForEach = usuarios.forEach(function (usuario){
    let edadUsuario = usuario.nombre + " : " + usuario.edad;
    console.log(edadUsuario);
    return edadUsuario;
});
console.log(rForEach);

// console.log(resultadoForEach);
let resultMap = usuarios.map(function (usuario){
    console.log(usuario.nombre + " :" + usuario.edad);
})
let resultMap2 = usuarios.map(function (usuario){
    let edadUsuario = usuario.nombre + " : " + usuario.edad;
    console.log(edadUsuario);
    return edadUsuario;
});
console.log(resultMap);
console.log(resultMap2);

let jsonPersonalizado = JSON.stringify(usuarios, null, '\t');
console.log(jsonPersonalizado);

let json = JSON.stringify(usuarios , ['nombre', 'edad', 'domicilio','direccion']);
console.log(json);

let jsonParse = JSON.parse(json);
console.log(jsonParse);

let jsonParse2 = JSON.parse(jsonPersonalizado);
console.log(jsonParse2);






// filter = funcion q devuelva un array de usuarios > 40

// let lista = [4,425,63,445,34,53,45,3,4,3];
// let result = lista.map(function(value){
//     return value + 3;
// })
// for (let i = 0; lista.length; i++ ) {
//     console.log(lista[i]);
// }
