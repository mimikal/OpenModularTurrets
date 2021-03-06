package omtteam.openmodularturrets.compatability.opencomputers;

import li.cil.oc.api.driver.NamedBlock;
import li.cil.oc.api.machine.Arguments;
import li.cil.oc.api.machine.Callback;
import li.cil.oc.api.machine.Context;
import net.minecraft.util.EnumFacing;
import omtteam.omlib.compatability.opencomputers.AbstractOMManagedEnvironment;
import omtteam.omlib.tileentity.EnumMachineMode;
import omtteam.omlib.util.TrustedPlayer;
import omtteam.openmodularturrets.tileentity.TurretBase;

import static omtteam.omlib.util.PlayerUtil.getPlayerUUID;

/**
 * Created by nico on 09/06/17.
 * The instance of the component wrapper for a specific turret base.
 */
public class ManagedEnvironmentTurretBase extends AbstractOMManagedEnvironment implements NamedBlock {
    private final TurretBase base;

    public ManagedEnvironmentTurretBase(TurretBase base) {
        super();
        this.base = base;
    }

    @Override
    public String preferredName() {
        return "turret_base";
    }

    @Override
    public int priority() {
        return 10;
    }

    @SuppressWarnings("unused")
    @Callback(doc = "function():string; returns owner of turret base.")
    public Object[] getOwner(Context context, Arguments args) {
        if (!base.isComputerAccessible()) {
            return new Object[]{"Computer access deactivated!"};
        }
        return new Object[]{base.getOwner()};
    }

    @SuppressWarnings("unused")
    @Callback(doc = "function():boolean; returns if the turret is currently set to attack hostile mobs.")
    public Object[] isAttacksMobs(Context context, Arguments args) {
        if (!base.isComputerAccessible()) {
            return new Object[]{"Computer access deactivated!"};
        }
        return new Object[]{base.isAttacksMobs()};
    }

    @SuppressWarnings("unused")
    @Callback(doc = "function(state:boolean):boolean;  sets to attack hostile mobs or not.")
    public Object[] setAttacksMobs(Context context, Arguments args) {
        if (!base.isComputerAccessible()) {
            return new Object[]{"Computer access deactivated!"};
        }
        base.setAttacksMobs(args.checkBoolean(0));
        return null;
    }

    @SuppressWarnings("unused")
    @Callback(doc = "function():boolean; returns if the turret is currently set to attack neutral mobs.")
    public Object[] isAttacksNeutrals(Context context, Arguments args) {
        if (!base.isComputerAccessible()) {
            return new Object[]{"Computer access deactivated!"};
        }
        return new Object[]{base.isAttacksNeutrals()};
    }

    @SuppressWarnings("unused")
    @Callback(doc = "function(state:boolean):boolean; sets to attack neutral mobs or not.")
    public Object[] setAttacksNeutrals(Context context, Arguments args) {
        if (!base.isComputerAccessible()) {
            return new Object[]{"Computer access deactivated!"};
        }
        base.setAttacksNeutrals(args.checkBoolean(0));
        return null;
    }

    @SuppressWarnings("unused")
    @Callback(doc = "function():boolean; returns if the turret is currently set to attack players.")
    public Object[] isAttacksPlayers(Context context, Arguments args) {
        if (!base.isComputerAccessible()) {
            return new Object[]{"Computer access deactivated!"};
        }
        return new Object[]{base.isAttacksPlayers()};
    }

    @SuppressWarnings("unused")
    @Callback(doc = "function(state:boolean):boolean; sets to attack players or not.")
    public Object[] setAttacksPlayers(Context context, Arguments args) {
        if (!base.isComputerAccessible()) {
            return new Object[]{"Computer access deactivated!"};
        }
        base.setAttacksPlayers(args.checkBoolean(0));
        return null;
    }

    @SuppressWarnings("unused")
    @Callback(doc = "function():table; returns a table of trusted players on this base.")
    public Object[] getTrustedPlayers(Context context, Arguments args) {
        if (!base.isComputerAccessible()) {
            return new Object[]{"Computer access deactivated!"};
        }
        return new Object[]{base.getTrustedPlayers()};
    }

    @SuppressWarnings("unused")
    @Callback(doc = "function(name:String, [canOpenGUI:boolean , canChangeTargeting:boolean , " + "admin:boolean]):string; adds Trusted player to Trustlist.")
    public Object[] addTrustedPlayer(Context context, Arguments args) {
        if (!base.isComputerAccessible()) {
            return new Object[]{"Computer access deactivated!"};
        }
        if (!base.addTrustedPlayer(args.checkString(0))) {
            return new Object[]{"Name not valid!"};
        }
        TrustedPlayer trustedPlayer = base.getTrustedPlayer(args.checkString(0));
        trustedPlayer.canOpenGUI = args.optBoolean(1, false);
        trustedPlayer.canChangeTargeting = args.optBoolean(1, false);
        trustedPlayer.admin = args.optBoolean(1, false);
        trustedPlayer.uuid = getPlayerUUID(args.checkString(0));
        return null;
    }

    @SuppressWarnings("unused")
    @Callback(doc = "function(name:String):string; removes trusted player from trust list.")
    public Object[] removeTrustedPlayer(Context context, Arguments args) {
        if (!base.isComputerAccessible()) {
            return new Object[]{"Computer access deactivated!"};
        }
        base.removeTrustedPlayer(args.checkString(0));
        return null;
    }

    @SuppressWarnings("unused")
    @Callback(doc = "function():int; returns maximum energy storage.")
    public Object[] getMaxEnergyStorage(Context context, Arguments args) {
        if (!base.isComputerAccessible()) {
            return new Object[]{"Computer access deactivated!"};
        }
        return new Object[]{base.getMaxEnergyLevel(EnumFacing.DOWN)};
    }

    @SuppressWarnings("unused")
    @Callback(doc = "function():int; returns current energy stored.")
    public Object[] getCurrentEnergyStorage(Context context, Arguments args) {
        if (!base.isComputerAccessible()) {
            return new Object[]{"Computer access deactivated!"};
        }
        return new Object[]{base.getEnergyLevel(EnumFacing.DOWN)};
    }

    @SuppressWarnings("unused")
    @Callback(doc = "function():boolean; returns if the turret is currently active.")
    public Object[] getActive(Context context, Arguments args) {
        if (!base.isComputerAccessible()) {
            return new Object[]{"Computer access deactivated!"};
        }
        return new Object[]{base.isActive()};
    }

    @SuppressWarnings("unused")
    @Callback(doc = "function(state:int):void; toggles turret redstone inversion state.")
    public Object[] setMode(Context context, Arguments args) {
        if (!base.isComputerAccessible()) {
            return new Object[]{"Computer access deactivated!"};
        } else if (!args.isInteger(0) || args.checkInteger(0) <= EnumMachineMode.values().length) {
            return new Object[]{"Set first parameter to any number between 0 and " + EnumMachineMode.values().length,
                    "0 - Always on, 1 - always off, 2 - inverted, 3 - not inverted"};
        }
        base.setMode(EnumMachineMode.values()[args.checkInteger(0)]);
        return null;
    }

    @SuppressWarnings("unused")
    @Callback(doc = "function():int; shows redstone inversion state.")
    public Object[] getInverted(Context context, Arguments args) {
        if (!base.isComputerAccessible()) {
            return new Object[]{"Computer access deactivated!"};
        }
        switch (base.getMode().ordinal()) {
            case 0:
                return new Object[]{"0 - Always on"};
            case 1:
                return new Object[]{"1 - always off"};
            case 2:
                return new Object[]{"2 - inverted"};
            case 3:
                return new Object[]{"3 - not inverted"};
        }
        return new Object[]{};
    }

    @SuppressWarnings("unused")
    @Callback(doc = "function():boolean; shows redstone state.")
    public Object[] getRedstone(Context context, Arguments args) {
        if (!base.isComputerAccessible()) {
            return new Object[]{"Computer access deactivated!"};
        }
        return new Object[]{base.getRedstone()};
    }

    @SuppressWarnings("unused")
    @Callback(doc = "function(side:int, yaw:double, pitch:double):void; Set yaw and pitch for all turrets (deact. auto targ. before).")
    public Object[] setAllYawPitch(Context context, Arguments args) {
        if (!base.isComputerAccessible()) {
            return new Object[]{"Computer access deactivated!"};
        }
        if (!args.isDouble(0) || !args.isDouble(1)) return new Object[]{"Wrong parameters!"};
        base.setAllTurretsYawPitch((float) args.checkDouble(0), (float) args.checkDouble(1));
        return new Object[]{};
    }

    @SuppressWarnings("unused")
    @Callback(doc = "function(yaw:double, pitch:double):boolean; Set yaw and pitch for a turret (deact. auto targ. before).")
    public Object[] setTurretYawPitch(Context context, Arguments args) {
        if (!base.isComputerAccessible()) {
            return new Object[]{"Computer access deactivated!"};
        }
        if (!args.isInteger(0) && args.checkInteger(0) <= 6 && args.checkInteger(0) >= 0 && !args.isDouble(1) || !args.isDouble(2))
            return new Object[]{"Wrong parameters!"};

        return new Object[]{base.setTurretYawPitch(EnumFacing.getFront(args.checkInteger(0)), (float) args.checkDouble(0), (float) args.checkDouble(1))};
    }

    @SuppressWarnings("unused")
    @Callback(doc = "function(state:boolean):void; Enable auto firing for all Turrets (deact. auto targ. before).")
    public Object[] setAllAutoForceFire(Context context, Arguments args) {
        if (!base.isComputerAccessible()) {
            return new Object[]{"Computer access deactivated!"};
        }
        if (!args.isBoolean(0)) return new Object[]{"Wrong parameters!"};
        base.setAllTurretsForceFire(args.checkBoolean(0));
        return new Object[]{};
    }

    @SuppressWarnings("unused")
    @Callback(doc = "function(state:boolean):boolean; Enable auto firing for specified Turret (deact. auto targ. before).")
    public Object[] setTurretAutoForceFire(Context context, Arguments args) {
        if (!base.isComputerAccessible()) {
            return new Object[]{"Computer access deactivated!"};
        }
        if (!args.isInteger(0) && args.checkInteger(0) <= 6 && args.checkInteger(0) >= 0 && !args.isBoolean(1))
            return new Object[]{"Wrong parameters!"};
        return new Object[]{base.setTurretForceFire(EnumFacing.getFront(args.checkInteger(0)), args.checkBoolean(1))};
    }

    @SuppressWarnings("unused")
    @Callback(doc = "function():int; Try to shoot all turrets, returns successful shots")
    public Object[] forceShootAll(Context context, Arguments args) {
        if (!base.isComputerAccessible()) {
            return new Object[]{"Computer access deactivated!"};
        }

        return new Object[]{base.forceShootAllTurrets()};
    }

    @SuppressWarnings("unused")
    @Callback(doc = "function(side:int):boolean; Try to shoot specified turret, returns true if successfully shot")
    public Object[] forceShootTurret(Context context, Arguments args) {
        if (!base.isComputerAccessible()) {
            return new Object[]{"Computer access deactivated!"};
        }
        if (!args.isInteger(0) && args.checkInteger(0) <= 6 && args.checkInteger(0) >= 0)
            return new Object[]{"Wrong parameters!"};
        return new Object[]{base.forceShootTurret(EnumFacing.getFront(args.checkInteger(0)))};
    }
}
