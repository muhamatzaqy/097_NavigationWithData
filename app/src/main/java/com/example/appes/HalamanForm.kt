package com.example.appes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanForm(
    onSubmitBUttonClicked: (MutableList<String>) -> Unit,
    onCancelButtonClicked: () -> Unit,
    ){
    var nama by rememberSaveable { mutableStateOf("") }
    var noHp by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var listData: MutableList<String> = mutableListOf(nama, noHp, alamat)

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Data Pelanggan")
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            OutlinedTextField(
                value = nama, onValueChange = { nama = it },
                label = { Text(text = stringResource(id = R.string.nama)) },
            )
            Spacer(modifier = Modifier.padding(15.dp))
            OutlinedTextField(
                value = noHp, onValueChange = { noHp = it },
                label = { Text(text = stringResource(id = R.string.noHp)) })
            Spacer(modifier = Modifier.padding(15.dp))
            OutlinedTextField(
                value = alamat, onValueChange = { alamat = it },
                label = {
                    Text(text = stringResource(id = R.string.alamat))
                })
            Spacer(modifier = Modifier.padding(2.dp))
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium))
                .weight(1f, false),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
            verticalAlignment = Alignment.Bottom
        ) {
            ElevatedButton(
                modifier = Modifier.weight(1f),
                onClick = onCancelButtonClicked
            ) {
                Text(stringResource(R.string.cancel))
            }
            ElevatedButton(
                modifier = Modifier.weight(1f),
                onClick = {onSubmitBUttonClicked(listData)}
            ) {
                Text(stringResource(R.string.lanjut))
            }
        }
    }
}