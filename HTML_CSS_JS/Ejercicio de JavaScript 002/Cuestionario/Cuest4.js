function actuConNumAleatorio(id) {
    const elemento = document.getElementById(id);
    if (!elemento) {
        throw new Error(`No se encontró ningún elemento con el id "${id}"`);
    }
    const numeroAleatorio = Math.floor(Math.random() * 100) +1;
    elemento.innerHTML = numeroAleatorio;
}   

try {
    const id = "miElemento";
    actuConNumAleatorio(id);
} catch (error) {
    console.error(error.message);
}