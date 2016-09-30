package com.caykeprudente.ru;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by Leandro on 29/09/2016.
 */

import android.support.v4.app.DialogFragment;
import android.app.AlertDialog;

public class NotificacaoDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.cardapio_not)
                .setSingleChoiceItems(R.array.notifica_opcoes, -1,new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }

                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        return builder.create();
    }
}