package cecylb.dsl.modelv2.builders;

import cecylb.dsl.modelv2.tmp.*;
import io.github.therealmone.tdf4j.parser.model.ast.ASTElement;

public class TTrBuilder extends AbstractBuilder {

    private ModifiableTTr builder;
    public  TTrBuilder() {

        addRule("object/size/SCL", leaf -> {
            switch(leaf.token().value()) {
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

        addRule("object/BRR", leaf -> {
            for(TTr.Rectangles rectangle : TTr.Rectangles.values()) {
                builder.rectangles().add(new Rectangle.Builder()
                .swx(rectangle.getSwX()*builder.sizeX()*2)
                .swy(rectangle.getSwY()*builder.sizeY()*2)
                .nex(rectangle.getNeX()*builder.sizeX()*2)
                .ney(rectangle.getNeY()*builder.sizeY()*2)
                .build());
            }
            for(int i=0; i<TTr.INPUTS.length; i++){
                builder.inputs().add(new Port.Builder()
                .portX(-builder.sizeX()* 2)
                .portY(((builder.sizeY() * 4) / (TTr.INPUTS.length + 1) * (i + 1)) - builder.sizeY() * 2)
                .portName(TTr.INPUTS[i])
                .portLabel(TTr.INPUTS[i])
                .build());
            }
            for(int i=0; i<TTr.OUTPUTS.length; i++){
                builder.outputs().add(new Port.Builder()
                        .portX(builder.sizeX()*2)
                        .portY(((builder.sizeY() * 4) / (TTr.OUTPUTS.length + 1) * (i + 1)) - builder.sizeY() * 2)
                        .portName(TTr.OUTPUTS[i])
                        .portLabel(TTr.OUTPUTS[i])
                        .build());
            }
        });

    }

    @Override
    public TexObject build(ASTElement tree) {
        builder = ModifiableTTr.create();
        process(tree);
<<<<<<< HEAD
        return builder.build();
=======
        return builder;
>>>>>>> Recs and Ports
    }
}