package cecylb.dsl.modelv2.builders.objects;

import cecylb.dsl.modelv2.tmp.*;
import cecylb.dsl.modelv2.tmp.MX;
import cecylb.dsl.modelv2.tmp.TexObject;
import io.github.therealmone.tdf4j.model.ast.ASTElement;

public class MXBuilder extends AbstractObjectBuilder {

    private ModifiableMX builder;
    public MXBuilder() {

        addRule("object/position/coordinates/x_coordinate/DBL", leaf -> {
            builder.setPosX(Double.parseDouble(leaf.token().value()));
        });

        addRule("object/position/coordinates/y_coordinate/DBL", leaf -> {
            builder.setPosY(Double.parseDouble(leaf.token().value()));
        });

        addRule("object/size/SCL", leaf -> {
            switch (leaf.token().value()) {
                case "small":
                    builder.setSizeX(Sizes.SMALL.getSizeX());
                    builder.setSizeY(Sizes.SMALL.getSizeY());
                    break;
                case "medium":
                    builder.setSizeX(Sizes.MEDIUM.getSizeX());
                    builder.setSizeY(Sizes.MEDIUM.getSizeY());
                    break;
                case "large":
                    builder.setSizeX(Sizes.LARGE.getSizeX());
                    builder.setSizeY(Sizes.LARGE.getSizeY());
                    break;
            }
        });

        addRule("object/size/coordinates/x_coordinate/DBL", leaf -> {
            builder.setSizeX(Double.parseDouble(leaf.token().value()));
        });

        addRule("object/size/coordinates/y_coordinate/DBL", leaf -> {
            builder.setSizeY(Double.parseDouble(leaf.token().value()));
        });

        addRule("object/label/LET", leaf -> {
            builder.setLabelName(leaf.token().value());
        });

        addRule("object/label/coordinates/x_coordinate/DBL", leaf -> {
            builder.setLabelX(Double.parseDouble(leaf.token().value()));
        });

        addRule("object/label/coordinates/y_coordinate/DBL", leaf -> {
            builder.setLabelY(Double.parseDouble(leaf.token().value()));
        });

        addRule("object/amount/NUM", leaf -> {
            builder.setAmount(Integer.parseInt(leaf.token().value()));
        });

        addRule("object/spacing/NUM", leaf -> {
            builder.setSpacing(Integer.parseInt(leaf.token().value()));
        });

        addRule("object/inputs/NUM", leaf -> {
            builder.setInput(Integer.parseInt(leaf.token().value()));
        });

        addRule("object/BFR", leaf -> {
            Character index = 'a';
            index = 'a';
            for (int i = 0; i < Math.pow(2, builder.input()); i++) {
                builder.outputs().add(new Port.Builder()
                        .portX(builder.sizeX() * 2)
                        .portY(((builder.sizeY() * 4) / (Math.pow(2, builder.input()) + 1) * (i + 1)) - builder.sizeY() * 2)
                        .portName("i" + index.toString())
                        .portLabel(String.valueOf(i))
                        .build());
                index++;
            }
            for (int i = 0; i < builder.input(); i++) {
                builder.outputs().add(new Port.Builder()
                        .portX(builder.sizeX() * 2)
                        .portY(((builder.sizeY() * 4) / (Math.pow(2, builder.input()) + 1) * (i + 1)) - builder.sizeY() * 2)
                        .portName("s" + index.toString())
                        .portLabel(String.valueOf(i))
                        .build());
                index++;
            }
            index = 'a';
            for(int i=0; i<DTr.OUTPUTS.length; i++){
                builder.outputs().add(new Port.Builder()
                        .portX(builder.sizeX()*2)
                        .portY(((builder.sizeY() * 4) / (DTr.OUTPUTS.length + 1) * (i + 1)) - builder.sizeY() * 2)
                        .portName(DTr.OUTPUTS[i])
                        .portLabel(DTr.OUTPUTS[i])
                        .build());
            }
            for (MX.Rectangles rectangle : MX.Rectangles.values()) {
                builder.rectangles().add(new Rectangle.Builder()
                        .swX(rectangle.getSwX() * builder.sizeX() * 2)
                        .swY(rectangle.getSwY() * builder.sizeY() *
                                (builder.input()+Math.pow(2, builder.input())) / 4)
                        .neX(rectangle.getNeX() * builder.sizeX() * 2)
                        .neY(rectangle.getNeY() * builder.sizeY() *
                                (builder.input()+Math.pow(2, builder.input())) / 4)
                        .build());
            }
        });
    }

    @Override
    public TexObject build(ASTElement tree) {
        builder = ModifiableMX.create();
        process(tree);
        return builder;
    }
}
