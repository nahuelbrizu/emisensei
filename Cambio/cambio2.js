const API_URL = 'https://www.dolarsi.com/api/api.php?type=valoresprincipales';
const XMLHttpRequest = require("xhr2").XMLHtt;
const xhr =  new XMLHttpRequest();

function objJson() {
    if (this.readyState === 4 && this.status === 200){
        const  data = JSON.parse(this.response)
        console.log(data);
    }
}
xhr.addEventListener("load", objJson);
xhr.open("GET", `${API_URL}/users`);
xhr.send();