package com.ugurkuyu.otelapp.model

data class Hotels(
    var id: Long,
    var details: Details,
    var rooms: List<Rooms>
) {

}
