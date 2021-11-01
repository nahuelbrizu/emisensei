let nume;
let prompt = require('prompt-sync')();
let lista = [];
do {
    nume = prompt('dame un numero ');
    if (nume != 0 && !isNaN(nume)) {
        lista.push(Number(nume));
        console.log(nume);
    }
    if (isNaN(nume)){
       console.log('eso no es un numero.');
    }
} while(isNaN(nume) || nume != 0);
console.log(lista);