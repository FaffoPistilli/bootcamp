const display = document.getElementById('display');
function appendValue(value) {
    display.value += value;
}
function clearDisplay() {
    display.value = '';
}
function calcular() {
    try {
        display.value = eval(display.value);
    }   catch (error) {
        alert('Expresion no Valida');
        clearDisplay();
    }
}