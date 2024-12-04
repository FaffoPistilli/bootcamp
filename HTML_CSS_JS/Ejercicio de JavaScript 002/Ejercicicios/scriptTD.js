function tirandoDados() {
    const contenedor = document.getElementById("dados");
    contenedor.innerHTML = "";
    for (let i = 0; i < 5; i++) {
        const numeroAleatorio = Math.floor(Math.random() *6) +1;
        const img = document.createElement("img");
        img.src = `IMGDADOS/dado${numeroAleatorio}.png`;
        img.alt = `Dado con número ${numeroAleatorio}`;
        contenedor.appendChild(img);
    }
}