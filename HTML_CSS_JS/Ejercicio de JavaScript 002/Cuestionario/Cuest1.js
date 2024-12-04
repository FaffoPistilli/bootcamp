function raizCuadraticaPositiva(a, b, c) {
    if (a === 0){
        throw new Error("El coeficiente 'a' no puede ser 0");
    }
    const discriminate = b * b - 4 * a * c;

    if (discriminate < 0) {
        throw new Error("La ecuacion no tiene solucion");
    }
    const raiz = (-b + Math.sqrt(discriminate)) / (2 * a);
    return raiz;
}

try {
    const a = 1;
    const b = -3;
    const c = 2;
    const resultado = raizCuadraticaPositiva(a, b, c);
    console.log(`La raíz cuadrática positiva es: ${resultado}`);
} catch (error) {
    console.error(error.message);
}