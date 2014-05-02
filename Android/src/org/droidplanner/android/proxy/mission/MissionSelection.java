package org.droidplanner.android.proxy.mission;

import java.util.ArrayList;
import java.util.List;

import org.droidplanner.android.mission.item.MissionItemRender;

public class MissionSelection {
	/**
	 * Classes interested in getting selection update should implement this interface.
	 */
	public interface OnSelectionUpdateListener {
	    public void onSelectionUpdate(List<MissionItemRender> selected);
	}

	/**
	 * Stores the selected mission items renders.
	 */
	public List<MissionItemRender> mSelectedItems =	new ArrayList<MissionItemRender>();
	/**
	 * Stores the list of selection update listeners.
	 */
	public List<MissionSelection.OnSelectionUpdateListener> mSelectionsListeners = 
			new ArrayList<MissionSelection.OnSelectionUpdateListener>();


	/**
	 * Removes the given mission item render from the selected list.
	 * TODO: check the argument belongs to this mission render
	 * @param item mission item rendere to remove from the selected list
	 */
	public void removeItemFromSelection(MissionItemRender item) {
	    mSelectedItems.remove(item);
	    notifySelectionUpdate();
	}

	/**
	 * Selects only the given mission items renders.
	 * TODO: check the mission items renders belong to this mission render
	 * @param items list of mission items renders to select.
	 */
	public void setSelectionTo(List<MissionItemRender> items){
	    mSelectedItems.clear();
	    mSelectedItems.addAll(items);
	    notifySelectionUpdate();
	}

	/**
	 * Selects only the given mission item render.
	 * TODO: check the mission item render belongs to this mission render
	 * @param item mission item render to select.
	 */
	public void setSelectionTo(MissionItemRender item) {
	    mSelectedItems.clear();
	    mSelectedItems.add(item);
	    notifySelectionUpdate();
	}

	/**
	 * Adds the given mission item render to the selected list.
	 * TODO: check the mission item render belongs to this mission render
	 * @param item mission item render to add to the selected list.
	 */
	public void addToSelection(MissionItemRender item) {
	    mSelectedItems.add(item);
	    notifySelectionUpdate();
	}

	/**
	 * Selects the given list of mission items renders
	 * TODO: check if the given mission items renders belong to this mission render
	 * @param items list of mission items renders to select.
	 */
	public void addToSelection(List<MissionItemRender> items) {
	    mSelectedItems.addAll(items);
	    notifySelectionUpdate();
	}

	/**
	 * Checks if the passed mission item render is selected.
	 * @param item mission item render to check for selection
	 * @return true if selected
	 */
	public boolean selectionContains(MissionItemRender item) {
	    return mSelectedItems.contains(item);
	}

	/**
	 * @return the list of selected mission items renders
	 */
	public List<MissionItemRender> getSelected() {
	    return mSelectedItems;
	}

	/**
	 * Deselects all mission items renders
	 */
	public void clearSelection() {
	    mSelectedItems.clear();
	    notifySelectionUpdate();
	}

	public void notifySelectionUpdate(){
	    for(MissionSelection.OnSelectionUpdateListener listener: mSelectionsListeners)
	        listener.onSelectionUpdate(mSelectedItems);
	}

	/**
	 * Adds given argument to the list of selection update listeners.
	 * @param listener
	 */
	public void addSelectionUpdateListener(OnSelectionUpdateListener listener){
	    mSelectionsListeners.add(listener);
	}

	/**
	 * Removes given argument from the list of selection update listeners.
	 * @param listener
	 */
	public void removeSelectionUpdateListener(MissionSelection.OnSelectionUpdateListener listener){
	    mSelectionsListeners.remove(listener);
	}
}