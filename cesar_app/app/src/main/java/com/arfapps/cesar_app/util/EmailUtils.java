package com.arfapps.cesar_app.util;

import com.arfapps.cesar_app.data.model.Email;
import com.arfapps.cesar_app.data.model.linked_list.LinkedNode;
import com.arfapps.cesar_app.data.model.linked_list.SingleLinkedList;

@SuppressWarnings("ConstantConditions")
public final class EmailUtils {

	/**
	 * Remove emails que possuem o mesmo título e conteudo, ou seja,
	 * são iguais perante o equals.
	 *
	 * @param emailList - cabeça da lista de emails
	 * @return lista de emails sem duplicacoes
	 */
	public static SingleLinkedList<Email> cleanDuplicatedEmails(SingleLinkedList<Email> emailList) {
		LinkedNode<Email> head = emailList.getHead();
		if (emailList == null || emailList.isEmpty()) {
			return emailList;
		}

		LinkedNode<Email> auxNode = head;
		for (; auxNode != null; auxNode = auxNode.getNext()) {
			if (auxNode.getNext() == null) {
				break;
			} else {
				LinkedNode<Email> next = auxNode.getNext();
				LinkedNode<Email> prevNode = auxNode;
				for (; next != null; next = next.getNext()) {
					if (isDuplicatedEmail(auxNode.getValue(), next.getValue())) {
						if (next.getNext() != null) {
							prevNode.setNext(next.getNext());
						} else {
							prevNode.setNext(null); // Final da lista
						}
					} else {
						prevNode = next; // atualiza prev somente para nao iguais
					}
				}
			}
		}
		emailList.updateSize();

		return emailList;
	}

	private static boolean isDuplicatedEmail(Email actual, Email compare) {
		return actual.equals(compare);
	}
}
