package ro.allamvizsga.projekt.service;

import ro.allamvizsga.projekt.message.KiallresztveszSaveMsg;
import ro.allamvizsga.projekt.model.Kiallresztvesz;

public interface KiallresztveszService {

	void updateKiallresztvesz(KiallresztveszSaveMsg kiallresztveszSaveMsg);

	void kiment(KiallresztveszSaveMsg kiallResztvesz);



}
