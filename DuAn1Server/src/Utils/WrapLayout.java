package Utils;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class WrapLayout implements LayoutManager {

    private int hgap;
    private int vgap;
    private List<Dimension> componentSizes;

    public WrapLayout() {
        this(5, 5);
    }

    public WrapLayout(int hgap, int vgap) {
        this.hgap = hgap;
        this.vgap = vgap;
        this.componentSizes = new ArrayList<>();
    }

    @Override
    public void addLayoutComponent(String name, Component comp) {
    }

    @Override
    public void removeLayoutComponent(Component comp) {
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        synchronized (parent.getTreeLock()) {
            Dimension dim = new Dimension(0, 0);
            int componentCount = parent.getComponentCount();

            for (int i = 0; i < componentCount; i++) {
                Component component = parent.getComponent(i);
                Dimension preferredSize = component.getPreferredSize();
                componentSizes.add(preferredSize);

                if (dim.width != 0) {
                    dim.width += hgap;
                }
                dim.width += preferredSize.width;

                if (preferredSize.height > dim.height) {
                    dim.height = preferredSize.height;
                }
            }

            Insets insets = parent.getInsets();
            dim.width += insets.left + insets.right + hgap * 2;
            dim.height += insets.top + insets.bottom + vgap * 2;

            return dim;
        }
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        synchronized (parent.getTreeLock()) {
            return preferredLayoutSize(parent);
        }
    }

    @Override
    public void layoutContainer(Container parent) {
        synchronized (parent.getTreeLock()) {
            Insets insets = parent.getInsets();
            int componentCount = parent.getComponentCount();
            int currentX = insets.left + hgap;
            int currentY = insets.top + vgap;
            int maxHeight = 0;
            if (componentCount > 0) {
                for (int i = 0; i < componentCount; i++) {
                    Component component = parent.getComponent(i);
                    Dimension preferredSize = componentSizes.get(i);
                    int componentWidth = preferredSize.width;
                    int componentHeight = preferredSize.height;

                    if (currentX + componentWidth > parent.getWidth() - insets.right - hgap) {
                        currentX = insets.left + hgap;
                        currentY += maxHeight + vgap;
                        maxHeight = 0;
                    }

                    component.setBounds(currentX, currentY, componentWidth, componentHeight);
                    currentX += componentWidth + hgap;

                    if (componentHeight > maxHeight) {
                        maxHeight = componentHeight;
                    }
                }
            }
        }
    }
}
