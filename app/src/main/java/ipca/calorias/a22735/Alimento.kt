package ipca.calorias.a22735

class Alimento {

    var name: String? = null
    var _calorias : Double = 0.0
    var calorias : Double
        get() {
            return _calorias
        }
        set(value) {
            _calorias = value
            if (_calorias < 0) {
                _calorias = 30.0
            }
        }
    var isChecked: Boolean? = false

    constructor(name: String?, calorias: Double, isChecked: Boolean?) {
        this.name = name
        this._calorias = calorias
        this.isChecked = isChecked
    }
}