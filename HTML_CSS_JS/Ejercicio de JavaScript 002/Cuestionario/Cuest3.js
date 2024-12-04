function actualizarInnerHTML (id, contenido){
    const elemento = document.getElementById(id);
    if (!elemento) {
        throw new Error(`No se encontró ningún elemento con el id "${id}"`);
    }
    elemento.innerHTML = contenido;
}   

try {
    const id = "miElemento";
    const texto = "Hola bootcampers!";
    actualizarInnerHTML(id, texto);
} catch (error) {
    console.error(error.message);
}