package com.cartoonishvillain.trapperpelts.client;
// Made with Blockbench 4.0.5
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.cartoonishvillain.trapperpelts.BearTrap;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class BearTrapModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation BEARTRAPLAYERLOCATION = new ModelLayerLocation(new ResourceLocation("modid", "beartrapmodel"), "main");
	private final ModelPart west;
	private final ModelPart center;
	private final ModelPart east;

	public BearTrapModel(ModelPart root) {
		this.west = root.getChild("west");
		this.center = root.getChild("center");
		this.east = root.getChild("east");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition west = partdefinition.addOrReplaceChild("west", CubeListBuilder.create().texOffs(0, 14).addBox(4.0F, 0.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(27, 4).addBox(3.0F, 0.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 27).addBox(2.0F, 0.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(27, 2).addBox(1.0F, 0.0F, -5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 27).addBox(0.0F, 0.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 3).addBox(-2.0F, 0.0F, -7.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(12, 0).addBox(0.0F, 0.0F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(23, 14).addBox(-1.0F, -2.0F, 6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(12, 23).addBox(1.0F, -2.0F, 4.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(23, 10).addBox(3.0F, -2.0F, 2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(23, 7).addBox(4.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(23, 2).addBox(4.0F, -2.0F, -2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 22).addBox(2.0F, -2.0F, -4.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 22).addBox(0.0F, -2.0F, -6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 22).addBox(-2.0F, -2.0F, -7.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 23.0F, 0.0F));

		PartDefinition cube_r1 = west.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(14, 13).addBox(0.0F, 0.0F, -7.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(26, 26).addBox(5.0F, 0.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(26, 23).addBox(4.0F, 0.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(26, 12).addBox(3.0F, 0.0F, -5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(11, 26).addBox(2.0F, 0.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 1.0F, 0.0F, 3.1416F, 0.0F, 0.0F));

		PartDefinition center = partdefinition.addOrReplaceChild("center", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition east = partdefinition.addOrReplaceChild("east", CubeListBuilder.create().texOffs(8, 11).addBox(4.0F, 0.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(26, 9).addBox(3.0F, 0.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(26, 0).addBox(2.0F, 0.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(23, 25).addBox(1.0F, 0.0F, -5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(19, 25).addBox(0.0F, 0.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(14, 11).addBox(-2.0F, 0.0F, -7.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 11).addBox(0.0F, 0.0F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(21, 17).addBox(-1.0F, -2.0F, 6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(15, 21).addBox(1.0F, -2.0F, 4.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(20, 20).addBox(3.0F, -2.0F, 2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(20, 12).addBox(4.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(20, 5).addBox(4.0F, -2.0F, -2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(12, 19).addBox(2.0F, -2.0F, -4.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(19, 9).addBox(0.0F, -2.0F, -6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 19).addBox(-2.0F, -2.0F, -7.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 23.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition cube_r2 = east.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(14, 8).addBox(0.0F, 0.0F, -7.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 25).addBox(5.0F, 0.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 25).addBox(4.0F, 0.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(15, 25).addBox(3.0F, 0.0F, -5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(25, 17).addBox(2.0F, 0.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 1.0F, 0.0F, 3.1416F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if(entity instanceof BearTrap && ((BearTrap) entity).getTriggered()) {
			west.setRotation(0, 0, -90);
			east.setRotation(0, 3.1416F, 90);
		} else {
			west.setRotation(0, 0, 0);
			east.setRotation(0, 3.1416F, 0);
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		west.render(poseStack, buffer, packedLight, packedOverlay);
		center.render(poseStack, buffer, packedLight, packedOverlay);
		east.render(poseStack, buffer, packedLight, packedOverlay);
	}
}