package com.upsam.hospital.controller.dto;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaDTO.
 */
public class ReglaDTO extends AbstractDTO {

	/** The descripcion. */
	private String descripcion;

	/** The tree1. */
	private List<Integer> tree1;

	/** The tree2. */
	private List<Integer> tree2;

	/**
	 * Gets the descripcion.
	 * 
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Gets the tree1.
	 * 
	 * @return the tree1
	 */
	public List<Integer> getTree1() {
		return tree1;
	}

	/**
	 * Gets the tree2.
	 * 
	 * @return the tree2
	 */
	public List<Integer> getTree2() {
		return tree2;
	}

	/**
	 * Sets the descripcion.
	 * 
	 * @param descripcion
	 *            the new descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Sets the tree1.
	 * 
	 * @param tree1
	 *            the new tree1
	 */
	public void setTree1(List<Integer> tree1) {
		this.tree1 = tree1;
	}

	/**
	 * Sets the tree2.
	 * 
	 * @param tree2
	 *            the new tree2
	 */
	public void setTree2(List<Integer> tree2) {
		this.tree2 = tree2;
	}

}
