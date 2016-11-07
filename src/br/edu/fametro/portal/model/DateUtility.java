package br.edu.fametro.portal.model;

import java.util.Calendar;
import java.util.Date;

public class DateUtility implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1126642857967380866L;

	public static Date getDataAtualDate() {
		Calendar dt = Calendar.getInstance();
		return dt.getTime();
	}

	public static String getDataAtualHtml() {
		Date dt = getDataAtualDate();
		return DateToHtml(dt);
	}

	public static String getDataAtualMask() {
		Date dt = getDataAtualDate();
		return DateToMask(dt);
	}

	public static Date HtmlToDate(String htmlDateInput) {
		// yyyy-MM-dd
		int ano = Integer.parseInt(htmlDateInput.split("-")[0]);
		int mes = Integer.parseInt(htmlDateInput.split("-")[1]);
		int dia = Integer.parseInt(htmlDateInput.split("-")[2]);

		Calendar dt = Calendar.getInstance();
		dt.set(Calendar.YEAR, ano);
		dt.set(Calendar.MONTH, mes - 1);
		dt.set(Calendar.DAY_OF_MONTH, dia);

		return dt.getTime();
	}

	public static Date maskToDate(String dateMaskInput) {
		// dd/MM/yyyy
		int dia = Integer.parseInt(dateMaskInput.split("/")[0]);
		int mes = Integer.parseInt(dateMaskInput.split("/")[1]);
		int ano = Integer.parseInt(dateMaskInput.split("/")[2]);

		Calendar dt = Calendar.getInstance();
		dt.set(Calendar.YEAR, ano);
		dt.set(Calendar.MONTH, mes - 1);
		dt.set(Calendar.DAY_OF_MONTH, dia);

		return dt.getTime();
	}

	public static String DateToHtml(Date javaDateType) {
		Calendar dt = Calendar.getInstance();
		dt.setTime(javaDateType);

		String dia = String.valueOf(dt.get(Calendar.DAY_OF_MONTH));
		String mes = String.valueOf(dt.get(Calendar.MONTH) + 1);
		String ano = String.valueOf(dt.get(Calendar.YEAR));

		while (dia.length() < 2) {
			dia = "0".concat(dia);
		}
		while (mes.length() < 2) {
			mes = "0".concat(mes);
		}
		while (ano.length() < 4) {
			ano = "0".concat(ano);
		}

		return ano.concat("-").concat(mes).concat("-").concat(dia);
	}

	public static String DateToMask(Date javaDateType) {
		Calendar dt = Calendar.getInstance();
		dt.setTime(javaDateType);

		String dia = String.valueOf(dt.get(Calendar.DAY_OF_MONTH));
		String mes = String.valueOf(dt.get(Calendar.MONTH) + 1);
		String ano = String.valueOf(dt.get(Calendar.YEAR));

		while (dia.length() < 2) {
			dia = "0".concat(dia);
		}
		while (mes.length() < 2) {
			mes = "0".concat(mes);
		}
		while (ano.length() < 4) {
			ano = "0".concat(ano);
		}

		return dia.concat("/").concat(mes).concat("/").concat(ano);
	}

	public static int getDia(Date data) {
		Calendar dt = Calendar.getInstance();
		dt.setTime(data);

		return dt.get(Calendar.DAY_OF_MONTH);
	}

	public static int getMes(Date data) {
		Calendar dt = Calendar.getInstance();
		dt.setTime(data);

		return dt.get(Calendar.MONTH);
	}

	public static int getSemestre(Date data) {
		Calendar dt = Calendar.getInstance();
		dt.setTime(data);

		int mes = dt.get(Calendar.MONTH) + 1;

		if (mes <= 6)
			return 1;
		else
			return 2;
	}

	public static int getAno(Date data) {
		Calendar dt = Calendar.getInstance();
		dt.setTime(data);

		return dt.get(Calendar.YEAR);
	}
}