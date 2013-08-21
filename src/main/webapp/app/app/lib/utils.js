function formataDecimalAmericanoParaBrasileiro(formato) {
    var num = new NumberFormat();
    num.setInputDecimal('.');
    num.setNumber(formato);
    num.setPlaces('2', false);
    num.setCurrencyValue('');
    num.setCurrency(true);
    num.setCurrencyPosition(num.LEFT_OUTSIDE);
    num.setNegativeFormat(num.LEFT_DASH);
    num.setNegativeRed(false);
    num.setSeparators(true, '.', ',');
    return num.toFormatted();
}
function formataDecimalBrasileiroParaAmericano(valor) {
    var num = new NumberFormat();
    num.setInputDecimal(',');
    num.setNumber(valor); // valor.value é '1.000,24'
    num.setPlaces('2', false);
    num.setCurrencyValue('');
    num.setCurrency(true);
    num.setCurrencyPosition(num.LEFT_OUTSIDE);
    num.setNegativeFormat(num.LEFT_DASH);
    num.setNegativeRed(false);
    num.setSeparators(false, ',', '.');
    return num.toFormatted();
}
