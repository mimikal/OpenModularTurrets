package omtteam.openmodularturrets.api;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import omtteam.openmodularturrets.tileentity.TurretBase;
import omtteam.openmodularturrets.util.TurretHeadUtil;

/**
 * Created by Keridos on 17/05/17.
 * This Class
 */
public interface ITurretBaseAddonBlock {
    /**
     * This should give the correct bounding box for the block based on its BlockState.
     * It is used for example for the block building preview.
     *
     * @param blockState the blockstate of the block
     * @param world      the World of the block
     * @param pos        the BlockPos of the block in the world
     * @return the correct bounding box for the block, based on its blockstate and pos.
     */
    AxisAlignedBB getBoundingBoxFromState(IBlockState blockState, World world, BlockPos pos);

    /**
     * This should give back the base that this addon block belongs to.
     *
     * @param world the World of the block
     * @param pos   the BlockPos of the block in the world
     * @return the corresponding base.
     */
    default TurretBase getBase(World world, BlockPos pos) {
        return TurretHeadUtil.getTurretBase(world, pos);
    }
}
