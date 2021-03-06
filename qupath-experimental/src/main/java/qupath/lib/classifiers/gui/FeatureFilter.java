package qupath.lib.classifiers.gui;

import java.util.List;

import org.bytedeco.javacpp.opencv_core.Mat;

import com.google.gson.annotations.JsonAdapter;

@JsonAdapter(FeatureFilters.FeatureFilterTypeAdapterFactory.class)
public abstract class FeatureFilter {
	   
	/**
	 * Name for this feature (should include any related parameter values to aid interpretation).
	 * @return
	 */
	public abstract String getName();
	
	/**
	 * Requested padding, in pixels, that should be added prior to calculating these 
	 * features to reduce boundary effects.
	 * <p>
	 * This provides an opportunity to use overlapping image tiles from a large image, 
	 * rather than giving tiles at the desired size and needing to pad some other way 
	 * (e.g. boundary replication or mirror padding).
	 * 
	 * @return
	 */
	public abstract int getPadding();
	
	/**
	 * Input image, and list into which any output images should be added.
	 * 
	 * @param matInput
	 * @param output
	 */
	public abstract void calculate(Mat matInput, List<Mat> output);
	
	@Override
	public String toString() {
		return getName();
	}
	
}