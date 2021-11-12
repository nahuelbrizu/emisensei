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
        nacionalidad: "venezuela",
        direccion: {
            calle: "santa florencia",
            altura: "123",
            barrio: "jean black"
        },
        hijos: ["esteban"]
    }
];




let argentinos = usuarios.filter( (usuario ) => usuario.nacionalidad == "Argentina");
console.log('Team Azulado : ', argentinos);

let otrasNac = usuarios.filter( (usuario ) => usuario.nacionalidad != "Argentina");
console.log('Team AntiAzulado : ', otrasNac);

let mayorQ40 = usuarios.filter(function (usuario) {
    return usuario.edad > 40;
}); console.log('MayorQ40 : ', mayorQ40);

let menorQ40 = usuarios.filter(function (usuario) {
    return usuario.edad < 40;
});console.log('menorQ40 : ', menorQ40);

// let ssumaMenores = usuarios.filter( (usuario) => usuario.edad > 40 ).reduce((acc, usuario) => acc + usuario.edad, 0);

let sumUsuarios = usuarios.reduce(function (acc, usuario){
    let suma = usuario.edad + acc;
    console.log(usuario.edad);
    console.log(acc);
    console.log("SUMA usuarios  ", acc, " : ", suma)
    return suma;
},0);
let sumaMayores = usuarios.filter( (usuario) => usuario.edad > 40 ).reduce((acc, usuario) => acc + usuario.edad, 0);
console.log('suma Mayores', sumaMayores);
let sumaMayores2 = usuarios.filter(function (usuario) {
    return usuario.edad > 40;
}).reduce(function (acc, usuario){
    let suma = usuario.edad + acc;
    console.log(usuario.edad);
    console.log(acc);
    console.log("SUMA  Mayores que 40", " : ", acc, " : ", suma)
    return suma;
},0);
console.log('suma Mayores', sumaMayores2);

let sum = menorQ40.reduce(function (acc, usuario){
    let suma = usuario.edad + acc;
    console.log(usuario.edad);
    console.log(acc);
    console.log("SUMA  menores",acc, " : ", suma)
    return suma;
},0);

let sumamenores2 = usuarios.filter(function (usuario) {
    return usuario.edad < 40;
}).reduce(function (acc, usuario){
    let suma = usuario.edad + acc;
    console.log(usuario.edad);
    console.log(acc);
    console.log("SUMA  menores que 40", " : ", acc, " : ", suma)

    return suma;
},0);console.log(sumamenores2);

let sumaMenores = usuarios.filter( (usuario) => usuario.edad > 40 ).reduce((acc , usuario) => acc + usuario.edad, 0);
console.log('suma menores ', sumaMenores);

console.log('suma Mayores', sum);



console.log("suma de tods : ", sumUsuarios);
