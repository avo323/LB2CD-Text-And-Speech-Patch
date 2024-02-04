;;; Sierra Script 1.0 - (do not remove this comment)
(script# 19)
(include sci.sh)
(use Main)
(use StopWalk)
(use SysWindow)
(use Ego_988)
(use InvI)


(class ego of Ego
	(properties
		x 0
		y 0
		z 0
		heading 0
		noun 1
		modNum 19
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		sightAngle 180
		actions 0
		onMeCheck $6789
		state $0002
		approachX 0
		approachY 0
		approachDist 0
		_approachVerbs 0
		yStep 2
		view 800
		loop 0
		cel 0
		priority 0
		underBits 0
		signal $2000
		lsTop 0
		lsLeft 0
		lsBottom 0
		lsRight 0
		brTop 0
		brLeft 0
		brBottom 0
		brRight 0
		scaleSignal $0000
		scaleX 128
		scaleY 128
		maxScale 128
		cycleSpeed 6
		script 0
		cycler 0
		timer 0
		detailLevel 0
		scaler 0
		illegalBits $8000
		xLast 0
		yLast 0
		xStep 3
		origStep 770
		moveSpeed 6
		blocks 0
		baseSetter 0
		mover 0
		looper 0
		viewer 0
		avoider 0
		code 0
		edgeHit 0
		wearingGown 0
	)
	
	(method (get param1)
		(if (== param1 -1)
			(super get: &rest)
		else
			(super get: param1 &rest)
			(gLb2Messager say: 2 4 0 0 0 19)
		)
	)
	
	(method (put)
		(if
			(and
				(not (gUser canControl:))
				(== gGIconBarCurIcon (gIconBar at: 5))
			)
			(= gGIconBarCurIcon (gIconBar at: 0))
			(gGame setCursor: global21)
		)
		(super put: &rest)
	)
	
	(method (normalize param1)
		(= view (if argc param1 else 800))
		(self
			setLoop: -1
			setCel: -1
			setPri: -1
			setMotion: 0
			setCycle: StopWalk -1
			setStep: 3 2
			z: 0
			illegalBits: -32768
			ignoreActors: 0
			setSpeed: global369
		)
	)
	
	(method (showInv &tmp theGLb2Win)
		(if (Inv firstTrue: #ownedBy gEgo)
			(= theGLb2Win gLb2Win)
			(= gLb2Win SysWindow)
			(Inv showSelf: gEgo)
			(if (not (gIconBar curInvIcon?))
				(gIconBar curIcon: (gIconBar at: 0) disable: 5)
				(if (& ((gIconBar curIcon?) signal?) $0004)
					(gIconBar advanceCurIcon:)
				)
				(gGame setCursor: ((gIconBar curIcon?) cursor?))
			)
			(= gLb2Win theGLb2Win)
			(gNarrator showTitle: 0 name: {Narrator})
		else
			(gLb2Messager say: 1 0 1 0 0 19)
		)
	)
)
